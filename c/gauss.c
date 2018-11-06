#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define Q 4

// #define USE_DOUBLE	// 倍精度実数を利用する
#define USE_PIVOT	// ピボット選択を利用する
#define USE_SCALE	// スケーリングを利用する

#define TRACE		

#ifdef USE_DOUBLE
	#define PRECISION "[倍精度実数]"
	#define FLOAT double		
	#define Abs(x) fabs(x)
#else
	#define PRECISION "[単精度実数]"
	#define FLOAT float		
	#define Abs(x) fabsf(x)		
#endif

#ifdef USE_PIVOT
	#define PIVOT "[ピボット選択あり]"
	#ifdef USE_SCALE
		#define SCALE "[スケーリングあり]"
	#else
		#define SCALE "[スケーリングなし]"
	#endif
#else
	#define PIVOT "[ピボット選択なし]"
	#define SCALE ""
#endif

#if Q == 1
	#define PROBLEM "動作テスト用問題(1) {厳密解：x1=-1.0, x2=1.0}"
	#define ROW 2	
	#define COL 3	
	FLOAT a[ROW][COL] = {	
		{1.0, 2.0,  1.0},
		{2.0, 1.0, -1.0},
	};

#elif Q == 2
	#define PROBLEM "動作テスト用問題(2) {厳密解：x1=0.5, x2=0.5, x3=0.5}"
	#define ROW 3	
	#define COL 4	
	FLOAT a[ROW][COL] = {	
		{2.0, 1.0, 1.0, 2.0},
		{1.0, 2.0, 1.0, 2.0},
		{1.0, 1.0, 2.0, 2.0},
	};

#elif Q == 3
	#define PROBLEM "動作テスト用問題(3) {厳密解：x1=0.5, x2=0.5}"
	#define ROW 2	
	#define COL 3	
	FLOAT a[ROW][COL] = {	
		{1.0e-10, 1.0, 0.5},
		{1.0,     1.0, 1.0},
	};

#elif Q == 4
	#define PROBLEM "動作テスト用問題(4) {厳密解：x1=0.0, x2=1.0, x3=0.0}"
	#define ROW 3	
	#define COL 4	
	FLOAT a[ROW][COL] = {	
		{9.000000e-15,	1.000000e-15,	5.000000e-15,	1.0e-15},
		{9.000001e+00,	1.000000e+00,	5.000000e+00,	1.0e+00},
		{9.000000e+15,	1.000000e+15,	5.000001e+15,	1.0e+15},
	};

#endif

void fatal(char *msg)
{
	fprintf(stderr, "!!! 解析失敗 !!! %s\n", msg);
	exit(1);
}

void printMat(char *title, FLOAT a[ROW][COL])
{
	int	i, j;
	printf("%s:\n", title);
	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			printf("%e\t", a[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void scaleRow(FLOAT a[ROW][COL], int k)
{
	int col;
	FLOAT abs_max = 0;

	for(col = 0; col < COL; col++){
		if(Abs(a[k][col]) > abs_max) abs_max = Abs(a[k][col]);
	}


	for(col = 0; col < COL; col++){
		a[k][col] /= abs_max;
	}

	printMat("scaleRow終了時",a);
}

void swapRow(FLOAT a[ROW][COL], int i1, int i2)
{
		int i;
		FLOAT tmp;
		if(i1 == i2) return;

		for(i = 0; i < ROW; i++){
			tmp = a[i][i1];
			a[i][i1] = a[i][i2];
			a[i][i2] = tmp;
		}
	printMat("swawrow終了時",a);
}

void pivot(FLOAT a[ROW][COL], int k)
{
	int i;
	int piv = k;
	FLOAT abs_max = Abs(a[k][k]);

	for(i = k; i < ROW; i++){
#ifdef USE_SCALE
		scaleRow(a, i);
#endif
		if(Abs(a[i][k]) > abs_max){
			piv = i;
			abs_max = Abs(a[i][k]);
		}
	}

	swapRow(a, k, piv);

}

void forward(FLOAT a[ROW][COL])
{
	int	i, j, k;
	FLOAT	s;
	for (k = 0; k < ROW-1; k++) {
#ifdef USE_PIVOT
		pivot(a, k);
#endif

		if (a[k][k] == 0.0) fatal("forward(): div/0.");
		for (i = k+1; i < ROW; i++) {
			s = a[i][k]/a[k][k];
			for (j = k; j < COL; j++) {
				a[i][j] -= s*a[k][j];
			}
		}
#ifdef TRACE
		printf("forward %d", k); printMat("",a);
#endif
	}
}

void backward(FLOAT a[ROW][COL])
{
	int	i, j, k;
	FLOAT	s;
	for (k = ROW-1; k > 0; k--) {
		if (a[k][k] == 0.0) fatal("backward(): div/0.");
		for (i = k-1; i >= 0; i--) {
			s = a[i][k]/a[k][k];
			for (j = k; j < COL; j++) {
				a[i][j] -= s*a[k][j];
			}
		}
#ifdef TRACE
		printf("backward %d", k); printMat("",a);
#endif
	}
}

void finish(FLOAT a[ROW][COL])
{
	int	k;
	FLOAT	s;
	for (k = 0; k < ROW; k++) {
		if (a[k][k] == 0.0) fatal("finish(): div/0.");
		s = a[k][k];
		a[k][k] /= s;		
		a[k][COL-1] /= s;
	}
}

void gauss(FLOAT a[ROW][COL])
{
	forward(a);
	backward(a);
	finish(a);
}

int main(int argc, char **argv)
{
	printf("ガウスの消去法\n\n");
	printf("計算方法：%s %s %s\n\n", PRECISION, PIVOT, SCALE);

	printMat(PROBLEM, a);
	gauss(a);
	printMat("結果", a);

	return (0);
}

