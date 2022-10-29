

#include"contact.h"


void Initcontact(struct Contact* ps)
{
	memset(ps->date,0,sizeof(ps->date));
	ps->size = 0;//����ͨѶ¼��ʼ��0��Ԫ��

	//��������ͨѶ¼��Ϣ
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
	//��ȡ�ļ�������ͨѶ¼��
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
		printf("ͨѶ¼�������޷�����\n");
	}
	else
	{
		printf("������ѧ��:>");
		scanf("%s",&(ps->date[ps->size].num));
		printf("����������:>");
		scanf("%s",&(ps->date[ps->size].name));
		printf("�������Ա�:>");
		scanf("%s",&(ps->date[ps->size].sex));
		printf("����������:>");
		scanf("%d",&(ps->date[ps->size].age));
		printf("������绰:>");
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
		printf("|%-20s|\t%-20s|\t%-5s|\t%s|\t%-12s|\n","ѧ��","����","�Ա�","����","�绰");
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
		printf("ͨѶ¼Ϊ��\n");

}

static int Findbystr(const struct Contact* ps,char str[MAXT],int t)//t��ѡ��ʲô���Ͳ���
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
	printf("********  0.��ѧ������      !0.����������********\n");
	printf("��ѡ��:>");
	scanf("%d",&t);
	if(t==0)
		printf("������ѧ��:>");
	else
		printf("����������:>");
	scanf("%s",&str);
	pos=Findbystr(ps,str,t);
	if(-1 == pos)
		printf("�޴���\n");
	else
	{
		printf("�����ɹ�\n");
		printf("-----------------------------------------------------------------------------\n");
		printf("|%-20s|\t%-20s|\t%-5s|\t%s|\t%-12s|\n","ѧ��","����","�Ա�","����","�绰");
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
	printf("********  0.��ѧ���޸�      !0.�������޸�       ********\n");
	scanf("%d",&t);
	if(t==0)
		printf("������ѧ��:>");
	else
		printf("����������:>");
	scanf("%s",&str);
	pos=Findbystr(ps,str,t);
	if(-1 == pos)
		printf("�޴���\n");
	else
	{
		printf("������ѧ��:>");
		scanf("%s",&(ps->date[pos].num));
		printf("����������:>");
		scanf("%s",&(ps->date[pos].name));
		printf("�������Ա�:>");
		scanf("%s",&(ps->date[pos].sex));
		printf("����������:>");
		scanf("%d",&(ps->date[pos].age));
		printf("������绰:>");
		scanf("%s",&(ps->date[pos].tele));
	}
}


void DelContact(struct Contact* ps)
{
	int t,pos;
	char str[MAXT];
	if(ps->size==0)
		return;
	printf("********  0.��ѧ��ɾ��      !0.������ɾ��  ********\n");
	scanf("%d",&t);
	printf("������ѧ�Ż�����:>");
	scanf("%s",&str);
	pos=Findbystr(ps,str,t);
	if(-1 == pos)
		printf("�޴���\n");
	else
	{
		int i=0;
		for(i=pos;i<ps->size-1;i++)
		{
			ps->date[i]=ps->date[i+1];
		}
		ps->size--;
		printf("ɾ���ɹ�\n");
	}
}

void menu2()
{
	printf("*********     1.����������  **********\n");
	printf("*********     2.����������  **********\n");
	printf("*********     3.��ѧ������  **********\n");
	printf("*********     0. �˳�����   **********\n");
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
		printf("��ѡ������ʽ:>");
		scanf("%d",&in);
		switch(in)
		{
		case out:
			printf("�˳�����ɹ�\n");
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
			printf("�������\n����������\n");
		}
	}while(in);
}


void cheak(struct Contact* ps)
{
	int i;
	if(ps->size==1)
		printf("��ӳɹ�\n");
	else
	{
		for(i=0;i<ps->size-1;i++)
		{
			if((strcmp((ps->date[i].num),ps->date[ps->size-1].num))==0)
			{
				printf("ѧ���ظ���Ч\n");
				ps->size--;
				return ;
			}
		}
		if(i>=(ps->size-1))
			printf("��ӳɹ�\n");
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
	else//дͨѶ¼���ݵ��ļ���
	{
		int i;
		for(i=0;i<ps->size;i++)
		{
			fwrite(&(ps->date[i]),sizeof(struct peoInfo),1,pfWrite);
		}
	}
	//�ر��ļ�
	fclose(pfWrite);
	pfWrite=NULL;
	printf("����ɹ�\n");
}

void look()
{
	time_t timep;//ϵͳʱ�� 
	struct tm *p_1;
	time (&timep);
	p_1=gmtime(&timep);
	printf("\t\t\t\t\t\t  ��ǰʱ��%02dʱ%02d��%\n",8+p_1->tm_hour,p_1->tm_min); 
	printf("\t\t\t\t\t\t   %d��%02d��%02d��\n",1900+p_1->tm_year,1+p_1->tm_mon,p_1->tm_mday);
	printf("\t������������������������������������������������������\n\n");
	Sleep(tim);
    printf("\t��\t\t\t\t\t������Զ�����������ֺ��� \t\t\t\t\t��\n\n");
	Sleep(tim);
    printf("\t��\t\t\t*****************************************************\t\t\t\t��\n\n");
    Sleep(tim);
	printf("\t��\t\t\t\t\t ѧ �� ͨ Ѷ ¼ \t\t\t\t\t\t��\n\n");
	Sleep(tim);
	printf("\t��\t\t\t  ������:Mr.Chen רҵ:�������xxxx ѧ��:xxxxxxxx  \t\t\t\t��\n\n");
    Sleep(tim);
	printf("\t��\t\t\t*****************************************************\t\t\t\t��\n\n");
    Sleep(tim);
	printf("\t��\t\t\t   ��ӭʹ���������21-03��ѧ��ͨѶ¼,ף��ʹ�����! \t\t\t\t��\n\n");
	Sleep(tim);
	printf("\t��\t\t\t                    �汾:1.0 bate��                 \t\t\t\t��\n\n");
    Sleep(tim);
	printf("\t������������������������������������������������������\n\n");
	Sleep(tim);
}
