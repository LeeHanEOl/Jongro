#include <stdio.h>
int main(void) {
	int a, b, c, d, e, f, i, testcase, arr[50] = 0;	
	
	while (1) {
		scanf_s("%d", &testcase);				// testcase �Է�
		if (testcase == 0)						// 0�̸� ����
			break;
				
		for (i = 0; i < testcase; i++) {		// ���� �迭�� ����
			scanf_s("%d", &arr[i]);
		}
		
		for ( a = 0 ; a <= testcase - 6 ; a++) {					// 6�� �ݺ���. ������ �ڸ����� ���������� ����
			for ( b = a + 1 ; b <= testcase - 5  ;  b++) {
				for ( c = b + 1  ; c <= testcase - 4  ;  c++) {
					for ( d = c + 1; d <= testcase - 3 ; d++) {
						for ( e = d + 1  ; e <= testcase - 2  ;  e++) {
							for ( f = e + 1 ; f <= testcase - 1  ;  f++) {
								printf("%d %d %d %d %d %d \n", arr[a], arr[b], arr[c], arr[d], arr[e], arr[f]);		// ���
							}
						}
					}
				}
			}
		}
		printf("\n");
	}
	return 0;
}