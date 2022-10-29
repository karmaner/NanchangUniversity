

#include"contact.h"


void Initcontact(struct Contact* ps)
{
	memset(ps->date,0,sizeof(ps->date));
	ps->size = 0;//设置通讯录开始有0个元素

	//加载已有通讯录信息
	LoadContact(ps);
}

void LoadContact(struct Contact* ps)
{
	struct peoInfo tmp={0};
	FILE* pfread=fopen("contact.dat","rb");
	if(pfread==NULL)
	{
		printf("LoadContact::%s\n",strerror(errno));
		return;
	}
	//读取文件，蠢到通讯录中
	while(fread(&tmp,sizeof(struct peoInfo),1,pfread))
	{
		ps->date[ps->size]=tmp;
		ps->size++;
	}
	fclose(pfread);
	pfread=NULL;
}

void AddContact(struct Contact* ps)
{
	if(ps->size==MAX)
	{
		printf("通讯录已满，无法增加\n");
	}
	else
	{
		printf("请输入学号:>");
		scanf("%s",&(ps->date[ps->size].num));
		printf("请输入姓名:>");
		scanf("%s",&(ps->date[ps->size].name));
		printf("请输入性别:>");
		scanf("%s",&(ps->date[ps->size].sex));
		printf("请输入年龄:>");
		scanf("%d",&(ps->date[ps->size].age));
		printf("请输入电话:>");
		scanf("%s",&(ps->date[ps->size].tele));
		ps->size++;
	}
}

void ShowContact(const struct Contact* ps)
{
	int i=0;
	if(ps->size)
	{
		printf("-----------------------------------------------------------------------------\n");
		printf("|%-20s|\t%-20s|\t%-5s|\t%s|\t%-12s|\n","学号","姓名","性别","年龄","电话");
		printf("-----------------------------------------------------------------------------\n");
		for(i=0;i<ps->size;i++)
		{
			printf("|%-20s|\t%-20s|\t%-5s|\t%-4d|\t%-12s|\n",
				ps->date[i].num,
				ps->date[i].name,
				ps->date[i].sex,
				ps->date[i].age,
				ps->date[i].tele);
		}
		printf("-----------------------------------------------------------------------------\n");
		printf("%d//%d",ps->size,MAX);
	}
	else
		printf("通讯录为空\n");

}

static int Findbystr(const struct Contact* ps,char str[MAXT],int t)//t是选择按什么类型查找
{
	int i;
	if(0==t)

	{
		for(i=0;i<ps->size;i++)
		{
		if(0==(strcmp((ps->date[i].name),str)))
			return i;
		}
		if(i==ps->size)
			return -1;
	}
	else
	{
		for(i=0;i<ps->size;i++)
		{
			if(0==(strcmp((ps->date[i].num),str)))
			return i;
		}
		if(i==ps->size)
			return -1;
	}

}
void SearchContact(const struct Contact* ps)
{
	int t,pos;
	char str[MAXT];
	printf("********  0.按学号搜索      !0.按姓名搜索********\n");
	printf("请选择:>");
	scanf("%d",&t);
	if(t==0)
		printf("请输入学号:>");
	else
		printf("请输入姓名:>");
	scanf("%s",&str);
	pos=Findbystr(ps,str,t);
	if(-1 == pos)
		printf("无此人\n");
	else
	{
		printf("搜索成功\n");
		printf("-----------------------------------------------------------------------------\n");
		printf("|%-20s|\t%-20s|\t%-5s|\t%s|\t%-12s|\n","学号","姓名","性别","年龄","电话");
		printf("-----------------------------------------------------------------------------\n");
			printf("|%-20s|\t%-20s|\t%-5s|\t%-4d|\t%-12s|\n",
				ps->date[pos].num,
				ps->date[pos].name,
				ps->date[pos].sex,
				ps->date[pos].age,
				ps->date[pos].tele);

	}
}

void ModifyContact(const struct Contact* ps)
{
	int t,pos;
	char str[MAXT];
	printf("********  0.按学号修改      !0.按姓名修改       ********\n");
	scanf("%d",&t);
	if(t==0)
		printf("请输入学号:>");
	else
		printf("请输入姓名:>");
	scanf("%s",&str);
	pos=Findbystr(ps,str,t);
	if(-1 == pos)
		printf("无此人\n");
	else
	{
		printf("请输入学号:>");
		scanf("%s",&(ps->date[pos].num));
		printf("请输入姓名:>");
		scanf("%s",&(ps->date[pos].name));
		printf("请输入性别:>");
		scanf("%s",&(ps->date[pos].sex));
		printf("请输入年龄:>");
		scanf("%d",&(ps->date[pos].age));
		printf("请输入电话:>");
		scanf("%s",&(ps->date[pos].tele));
	}
}


void DelContact(struct Contact* ps)
{
	int t,pos;
	char str[MAXT];
	if(ps->size==0)
		return;
	printf("********  0.按学号删除      !0.按姓名删除  ********\n");
	scanf("%d",&t);
	printf("请输入学号或姓名:>");
	scanf("%s",&str);
	pos=Findbystr(ps,str,t);
	if(-1 == pos)
		printf("无此人\n");
	else
	{
		int i=0;
		for(i=pos;i<ps->size-1;i++)
		{
			ps->date[i]=ps->date[i+1];
		}
		ps->size--;
		printf("删除成功\n");
	}
}

void menu2()
{
	printf("*********     1.按名字排序  **********\n");
	printf("*********     2.按年龄排序  **********\n");
	printf("*********     3.按学号排序  **********\n");
	printf("*********     0. 退出排序   **********\n");
}


void sortbyname(struct Contact* ps)
{
	int i,j,flag=1;
	for(i=0;i<ps->size;i++)
	{
		for(j=0;j<ps->size-i-1;j++)
		{
			if((strcmp((ps->date[j].name),ps->date[j+1].name))>=0)
			{
				struct peoInfo tmp=ps->date[j];
				ps->date[j]=ps->date[j+1];
				ps->date[j+1]=tmp;
				flag=0;
			}
			if(flag)
				break;
		}
	}
}

void sortbyage(struct Contact* ps)
{
	int i,j,flag=1;
	for(i=0;i<ps->size;i++)
	{
		for(j=0;j<ps->size-i-1;j++)
		{
			if(ps->date[j].age>=ps->date[j+1].age)
			{
				struct peoInfo tmp=ps->date[j];
				ps->date[j]=ps->date[j+1];
				ps->date[j+1]=tmp;
				flag=0;
			}
			if(flag)
				break;
		}
	}
}

void sortbynum(struct Contact* ps)
{
	int i,j,flag=1;
	for(i=0;i<ps->size;i++)
	{
		for(j=0;j<ps->size-i-1;j++)
		{
			if((strcmp((ps->date[j].num),ps->date[j+1].num))>=0)
			{
				struct peoInfo tmp=ps->date[j];
				ps->date[j]=ps->date[j+1];
				ps->date[j+1]=tmp;
				flag=0;
			}
			if(flag)
				break;
		}
	}
}


void SortContact(struct Contact* ps)
{
	int in;
	do
	{
		menu2();
		printf("请选择排序方式:>");
		scanf("%d",&in);
		switch(in)
		{
		case out:
			printf("退出排序成功\n");
			break;
		case name:
			sortbyname(ps);
			break;
		case age:
			sortbyage(ps);
			break;
		case num:
			sortbynum(ps);
		default:
			printf("输入错误\n请重新输入\n");
		}
	}while(in);
}


void cheak(struct Contact* ps)
{
	int i;
	if(ps->size==1)
		printf("添加成功\n");
	else
	{
		for(i=0;i<ps->size-1;i++)
		{
			if((strcmp((ps->date[i].num),ps->date[ps->size-1].num))==0)
			{
				printf("学号重复无效\n");
				ps->size--;
				return ;
			}
		}
		if(i>=(ps->size-1))
			printf("添加成功\n");
	}
}

void saveContact(struct Contact* ps)
{
	FILE* pfWrite = fopen("contact.dat","wb");
	if(pfWrite==NULL)
	{
		printf("saveContact::%s\n",strerror(errno));
		return;
	}
	else//写通讯录数据到文件中
	{
		int i;
		for(i=0;i<ps->size;i++)
		{
			fwrite(&(ps->date[i]),sizeof(struct peoInfo),1,pfWrite);
		}
	}
	//关闭文件
	fclose(pfWrite);
	pfWrite=NULL;
	printf("保存成功\n");
}

void look()
{
	time_t timep;//系统时间 
	struct tm *p_1;
	time (&timep);
	p_1=gmtime(&timep);
	printf("\t\t\t\t\t\t  当前时间%02d时%02d分%\n",8+p_1->tm_hour,p_1->tm_min); 
	printf("\t\t\t\t\t\t   %d年%02d月%02d日\n",1900+p_1->tm_year,1+p_1->tm_mon,p_1->tm_mday);
	printf("\t★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n\n");
	Sleep(tim);
    printf("\t★\t\t\t\t\t有朋自远方来，不亦乐乎！ \t\t\t\t\t★\n\n");
	Sleep(tim);
    printf("\t★\t\t\t*****************************************************\t\t\t\t★\n\n");
    Sleep(tim);
	printf("\t★\t\t\t\t\t 学 生 通 讯 录 \t\t\t\t\t\t★\n\n");
	Sleep(tim);
	printf("\t★\t\t\t  制作者:Mr.Chen 专业:软件工程xxxx 学号:xxxxxxxx  \t\t\t\t★\n\n");
    Sleep(tim);
	printf("\t★\t\t\t*****************************************************\t\t\t\t★\n\n");
    Sleep(tim);
	printf("\t★\t\t\t   欢迎使用软件工程21-03的学生通讯录,祝您使用愉快! \t\t\t\t★\n\n");
	Sleep(tim);
	printf("\t★\t\t\t                    版本:1.0 bate版                 \t\t\t\t★\n\n");
    Sleep(tim);
	printf("\t★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★\n\n");
	Sleep(tim);
}
