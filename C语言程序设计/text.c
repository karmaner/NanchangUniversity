

#include"contact.h"

//打印菜单和里面的功能
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
	//创建通讯录
	struct Contact con;//con是通讯录包含一千个元素和size
	look();
	//初始化数组
	Initcontact(&con);
	do
	{
		menu();
		printf("请选择功能:>");
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
			printf("自动保存\n");
			saveContact(&con);
			printf("退出成功\n");
			break;
		default :
			printf("输入错误请重新输入\n");
			break;
		}
	} while(input);
	return 0;
}
