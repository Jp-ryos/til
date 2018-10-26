#include<stdio.h>

//int DecimalToBinary(int dec, int bit)

int myPow(int value, int digit)
{
	int i = 0;
	int calc = 1;

	if(digit < 0) return -1;

	if(digit == 0) return 1;
	else if(digit % 2 == 0) calc = myPow(value * value, digit / 2);
	else calc = value * myPow(value, digit - 1);

	return calc;
}

int DecimalToBinary(int dec)
{
	int bin[8];
	int changedvalue, digit;
	int i = 0;
	changedvalue = 0;
	digit = 7;

	if(dec > 256) return -1;

	for(i = 0; i < 8; i++) bin[i] = 0;

	while(dec > 0){
		bin[digit] = dec % 2;
		dec /= 2;
		digit--;
	}

	for(i = 7; i >= 0; i--) changedvalue += bin[i] * myPow(10,  7- i);
	return changedvalue;

}




int main()
{
	printf("255: %08d\n", DecimalToBinary(255));
	printf("002: %08d\n", DecimalToBinary(2));
	return 0;
}
