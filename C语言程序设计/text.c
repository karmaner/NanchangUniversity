

#include"contact.h"

//��ӡ�˵�������Ĺ���
void menu()
{
	printf("\t\t\t\t********************************************************\n");
	printf("\t\t\t\t**********      1.add       2.show           ***********\n");
	printf("\t\t\t\t**********      3.search    4.modify         ***********\n");
	printf("\t\t\t\t**********      5.del       6.sort           ***********\n");
	printf("\t\t\t\t**********      7.save      8.about          ***********\n");
	printf("\t\t\t\t**********      9.help      0.exit           ***********\n");
	printf("\t\t\t\t********************************************************\n");
}
int main()
{
	int input=0;
	//����ͨѶ¼
	struct Contact con;//con��ͨѶ¼����һǧ��Ԫ�غ�size
	look();
	//��ʼ������
	Initcontact(&con);
	do
	{
		menu();
		printf("��ѡ����:>");
		scanf("%d",&input);
		switch(input)
		{
		case ADD:
			AddContact(&con);
			cheak(&con);
			break;
		case SHOW:
			ShowContact(&con);
			break;
		case SEARCH:
			SearchContact(&con);
			break;
		case MODIFY:
			ModifyContact(&con);
			break;
		case DEL:
			DelContact(&con);
			break;
		case SORT:
			SortContact(&con);
			ShowContact(&con);
			break;
		case SAVE:
			saveContact(&con);
			break;
		case ABOUT:
			break;
		case HELP:
			break;
		case EXIT:
			printf("�Զ�����\n");
			saveContact(&con);
			printf("�˳��ɹ�\n");
			break;
		default :
			printf("�����������������\n");
			break;
		}
	} while(input);
	return 0;
}
