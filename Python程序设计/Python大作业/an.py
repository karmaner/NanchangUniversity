import pandas as pd
from pyecharts.charts import Scatter, Tab
from pyecharts.charts import Polar
from pyecharts import options as opts
from pyecharts.commons.utils import JsCode
from pyecharts.globals import ThemeType
from pyecharts import options as opts
from pyecharts.charts import Map, Timeline, Bar, Line
from pyecharts.options import ComponentTitleOpts
from pyecharts import options as opts
from pyecharts.charts import Tab
from pyecharts.components import Table

# 数据读取
df = pd.read_excel("2000-2019年分地区人均可支配收入、城市和农村可支配收入以及泰尔指数.xlsx")

province_map = {
    "Anhui": "安徽",
    "Beijing": "北京",
    "Chongqing": "重庆",
    "Fujian": "新疆",
    "Gansu": "甘肃",
    "Guangdong": "广东",
    "Guangxi": "广西",
    "Guizhou": "贵州",
    "Hainan": "海南",
    "Hebei": "河北",
    "Heilongjiang": "黑龙江",
    "Henan": "河南",
    "Hong Kong": "香港",
    "Hubei": "湖北",
    "Hunan": "湖南",
    "Inner Mongolia": "内蒙古",
    "Jiangsu": "江苏",
    "Jiangxi": "江西",
    "Jilin": "吉林",
    "Liaoning": "辽宁",
    "Macau": "澳门",
    "Ningxia": "宁夏",
    "Qinghai": "青海",
    "Shaanxi": "陕西",
    "Shandong": "山东",
    "Shanghai": "上海",
    "Shanxi": "山西",
    "Sichuan": "四川",
    "Tianjin": "天津",
    "Tibet": "西藏",
    "Xinjiang": "新疆",
    "Yunnan": "云南",
    "Zhejiang": "浙江",
    "Fujian": "福建",
    "Taiwan": "台湾",
}

# TODO:画年份统计城农收入差异
# 按年份进行分组并计算统计信息
year_group = df.groupby('year')
income_total = year_group['总收入(元)'].sum()
income_town = year_group["城镇总收入（元）"].sum()
income_countryside = year_group["农村总收入（元）"].sum()
income_rate = income_town / income_countryside

# 创建表格对象
table = Table()
headers = ["年份", "总收入", "城镇总收入", "农村总收入", "收入比率"]
rows = []

# 添加数据行
for year, total, town, countryside, rate in zip(income_total.index, income_total, income_town, income_countryside, income_rate):
    rows.append([year, total, town, countryside, f"{rate:.2%}"])

# 设置表格的标题、行、列数据
table.add(headers, rows)

# 创建 Tab 组件
tab = Tab()
# 将表格添加到 Tab 组件中
tab.add(table, "按年份统计")

# 设置 Tab 组件的全局选项
tab.set_global_opts(title_opts=opts.ComponentTitleOpts(title="全国地区城镇农村收入情况", subtitle="没有港澳台的数据城镇化率会偏低"))

# 渲染生成 HTML 文件
tab.render("table.html")

# TODO:创建折线图观察收入比率变化率
# 创建折线图对象
line = (
    Line()
    .add_xaxis(year_group.groups.keys())
    .add_yaxis("收入比率", income_rate.values, markpoint_opts=opts.MarkPointOpts(data=[opts.MarkPointItem(type_="max")]))
    .set_global_opts(
        title_opts=opts.TitleOpts(title="收入比率变化折线图"),
        xaxis_opts=opts.AxisOpts(name="年份", min_=2000, interval=1),
        yaxis_opts=opts.AxisOpts(name="收入比率"),
    )
)

# 渲染生成 HTML 文件
line.render("income_rate_line.html")