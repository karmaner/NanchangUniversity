


#define MAX   1000//ͨѶ¼����

//��������Ĵ�С
#define MAX_NUM  20//ѧ�Ÿ���
#define MAX_NAME 20
#define MAX_SEX  5
#define MAX_TELE 12
#define MAXT 20
#define tim 500


#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<errno.h>
#include<time.h>
#include<Windows.h>

struct peoInfo//�����ṹ������Ϣ
{
	char num[MAX_NUM];
	char name[MAX_NAME];
	char sex[MAX_SEX];
	int age;
	char tele[MAX_TELE];

};

//����ͨѶ¼����
struct Contact
{
	struct peoInfo date[MAX];
	int size;//��¼���е�����
};


enum//ö�����ӳ���ɶ��Բ���ÿ�ζ����˵�
{
	EXIT,//0
	ADD,//1
	SHOW,//2
	SEARCH,
	MODIFY,
	DEL,
	SORT,
	SAVE,
	ABOUT,
	HELP
};


enum
{
	out,//0
	name,//1
	age,
	num,
};

//��������

//���غ���
void cheak(struct Contact* ps);

//��ʼ������
void Initcontact(struct Contact* ps);

//���Ԫ��
void AddContact(struct Contact* ps);

//��ӡͨѶ¼
void ShowContact(const struct Contact* ps);

//�����˰�����\��ѧ��
void SearchContact(const struct Contact* ps);

//�޸ĳ�Ա
void ModifyContact(const struct Contact* ps);

//ɾ����Ա
void DelContact(struct Contact* ps);

//������
void SortContact(struct Contact* ps);

//�����ļ�
void saveContact(struct Contact* ps);

//�ͷ�ͨѶ¼�ռ�
void DestoryContact(struct Contact* ps);

//�����ļ���Ϣ��ͨѶ¼
void LoadContact(struct Contact* ps);

//����ҳ��
void look();
