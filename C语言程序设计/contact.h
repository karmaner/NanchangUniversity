


#define MAX   1000//通讯录容量

//各类数组的大小
#define MAX_NUM  20//学号个数
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

struct peoInfo//创建结构体人信息
{
	char num[MAX_NUM];
	char name[MAX_NAME];
	char sex[MAX_SEX];
	int age;
	char tele[MAX_TELE];

};

//定义通讯录类型
struct Contact
{
	struct peoInfo date[MAX];
	int size;//记录已有的人数
};


enum//枚举增加程序可读性不必每次都看菜单
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

//声明函数

//查重函数
void cheak(struct Contact* ps);

//初始化函数
void Initcontact(struct Contact* ps);

//添加元素
void AddContact(struct Contact* ps);

//打印通讯录
void ShowContact(const struct Contact* ps);

//查找人按姓名\按学号
void SearchContact(const struct Contact* ps);

//修改成员
void ModifyContact(const struct Contact* ps);

//删除成员
void DelContact(struct Contact* ps);

//排序函数
void SortContact(struct Contact* ps);

//保存文件
void saveContact(struct Contact* ps);

//释放通讯录空间
void DestoryContact(struct Contact* ps);

//加载文件信息到通讯录
void LoadContact(struct Contact* ps);

//启动页面
void look();
