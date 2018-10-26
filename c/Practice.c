#include<stdio.h>
#include<string.h>

void plus(char *str)
{
	*str = "11111";
}

int main()
{
	int i = 0;
	char *str = "123";
	plus(str);
	printf("%s", str);

	return 0;
}
