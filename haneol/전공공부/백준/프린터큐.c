#include <stdio.h>
#include <string.h>

int location = 0;

typedef struct _NODE {

	int data;
	struct _NODE *next;

}NODE;

void addHead(NODE *pHead, int data) {

	NODE *pNode = malloc(sizeof(NODE));
	pNode->data = data;

	pNode->next = pHead->next;
	pHead->next = pNode;
}

void addTail(NODE *pHead, int data) {

	NODE *cur = pHead;
	while (cur->next != NULL) {
		cur = cur->next;
	}
	addHead(cur, data);
}

int getHead(NODE * pHead) {

	return pHead->next->data;

}

void removeHead(NODE * pHead) {

	NODE * pNode = pHead->next;
	pHead->next = pNode->next;
	free(pNode);
}

int isEmpty(NODE * pHead) {

	return pHead->next == NULL;

}

int countNode(NODE * pHead) {

	int count;
	NODE * cur = pHead->next;

	for (count = 0; cur != NULL; count++)
		cur = cur->next;

	return count;
}

int compare(NODE * pHead) {

	int first = 0;
	int key = 0;

	NODE * cur = pHead->next;

	first = cur->data;			// ó�� �� ����

	while (cur != NULL) {
		if (first < cur->data) {
			key += 1;
			break;
		}
		cur = cur->next;
	}

	return key;				// ó�� ���� ���� ũ�� 0�� ���ų� ������ 1�� ��ȯ�Ѵ�.
}

void clear(NODE * pHead) {

	while (isEmpty(pHead) == 0)
		removeHead(pHead);
}

int main(void) {
	NODE head = { 0 };
	int goal = 0;						// ����ϰ��� �ϴ� ��. �۾� ó���ø��� 1�� ����
	int i, j, k, l, testcase, length = 0;
	int priority[100];
	scanf_s("%d", &testcase);

	for (i = 0; i < testcase; i++) {
		location = 0;								// testcase�� �ٲ𶧸��� �� ���� �ʱ�ȭ
		goal = 0;									// testcase�� �ٲ𶧸��� �� ���� �ʱ�ȭ
		scanf_s("%d", &length);
		scanf_s("%d", &location);
		
		for (j = 0; j < length; j++) {
			scanf_s("%d", &priority[j]);
		}

		for (k = 0; k < length; k++) {
			addTail(&head, priority[k]);			// ���Ḯ��Ʈ�� ������ �����ϴ� ���� (ť�� ���ۿ��� ����)
		}
		/////////////////////////////////////////////////////////////////////////////////////
		while( !isEmpty(&head) ){					// ��������� 1�� ��������� 0�� �����Ѵ�.
			if (compare(&head) == 0) {				// �����۾��� ���� ũ�� 0�� �ƴϸ� 1�� ��ȯ
				goal += 1;							// ���� �۾��� ó���Ҷ����� 1�� ����
				if (location == 0) {				// location index�� �� ���̸� 
					printf("%d\n", goal);			//  ������ ����� ����� ����
					break;
				}else {								// �ƴϸ� ��� ����
				}								
				removeHead(&head);					// ��� ����
				location -= 1;						// ���� �� �����̼� 1 ����
			}else {									// �����߰� �� ��� ����
				addTail(&head, getHead(&head));		// ���� �߰�
				removeHead(&head);					// ��� ����

				if (location == 0) {					// �ش� �ε����� �� ���϶�
					location += countNode(&head) - 1;	// �ε����� �� �ڷ� ����
				}
				else {
					location -= 1;						// �ش� �ε����� �� ���� �ƴ� ��� �ε����� 1 ����
				}
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////
		clear(&head);							// �� �����
	}
	return 0;
}