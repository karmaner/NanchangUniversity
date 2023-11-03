#! /usr/bin/env python
# --*-- coding:utf-8 --*--

import sys
from optparse import OptionParser
import random

parser = OptionParser()
parser.add_option("-s", "--seed", default=0, help="随机种子(默认为0)".decode('utf-8'), 
                  action="store", type="int", dest="seed")
parser.add_option("-j", "--jobs", default=3, help="系统中的作业数(默认为3)".decode('utf-8'),
                  action="store", type="int", dest="jobs")
parser.add_option("-l", "--jlist", default="", help="替代随机作业，提供逗号分隔的运行时间列表".decode('utf-8'),
                  action="store", type="string", dest="jlist")
parser.add_option("-m", "--maxlen", default=10, help="作业最大长度(默认为10)".decode('utf-8'),
                  action="store", type="int", dest="maxlen")
parser.add_option("-p", "--policy", default="FIFO", help="使用调度策略: SJF, FIFO, RR".decode('utf-8'),
                  action="store", type="string", dest="policy")
parser.add_option("-q", "--quantum", help="RR策略的时间片长度(默认为1)".decode('utf-8'), default=1, 
                  action="store", type="int", dest="quantum")
parser.add_option("-c", help="为我计算答案".decode('utf-8'), action="store_true", default=False, dest="solve")

(options, args) = parser.parse_args()

random.seed(options.seed)

print '参数policy', options.policy
if options.jlist == '':
    print '参数jobs', options.jobs
    print '参数maxlen', options.maxlen
    print '参数seed', options.seed
else:
    print '参数jlist', options.jlist

print ''

print '带有运行时间的作业列表: '

import operator

joblist = []
if options.jlist == '':
    for jobnum in range(0,options.jobs):
        runtime = int(options.maxlen * random.random()) + 1
        joblist.append([jobnum, runtime])
        print '  Job', jobnum, '( 执行时间 = ' + str(runtime) + ' )'
else:
    jobnum = 0
    for runtime in options.jlist.split(','):
        joblist.append([jobnum, float(runtime)])
        jobnum += 1
    for job in joblist:
        print '  Job', job[0], '( 执行时间 = ' + str(job[1]) + ' )'
print '\n'

if options.solve == True:
    print '** 解决方案 **\n'
    if options.policy == 'SJF':
        joblist = sorted(joblist, key=operator.itemgetter(1))
        options.policy = 'FIFO'
    
    if options.policy == 'FIFO':
        thetime = 0
        print '执行跟踪:'
        for job in joblist:
            print '  [ time %3d ] Run job %d for %.2f secs ( DONE at %.2f )' % (thetime, job[0], job[1], thetime + job[1])
            thetime += job[1]

        print '\n最终统计:'
        t     = 0.0
        count = 0
        turnaroundSum = 0.0
        waitSum       = 0.0
        responseSum   = 0.0
        for tmp in joblist:
            jobnum  = tmp[0]
            runtime = tmp[1]
            
            response   = t
            turnaround = t + runtime
            wait       = t
            print '  Job %3d -- 响应时间: %3.2f  周转时间: %3.2f  等待时间: %3.2f' % (jobnum, response, turnaround, wait)
            responseSum   += response
            turnaroundSum += turnaround
            waitSum       += wait
            t += runtime
            count = count + 1
        print '\n  平均 -- 响应时间: %3.2f  周转时间: %3.2f  等待时间: %3.2f\n' % (responseSum/count, turnaroundSum/count, waitSum/count)
                     
    if options.policy == 'RR':
        print '执行跟踪:'
        turnaround = {}
        response = {}
        lastran = {}
        wait = {}
        quantum  = float(options.quantum)
        jobcount = len(joblist)
        for i in range(0,jobcount):
            lastran[i] = 0.0
            wait[i] = 0.0
            turnaround[i] = 0.0
            response[i] = -1

        runlist = []
        for e in joblist:
            runlist.append(e)

        thetime  = 0.0
        while jobcount > 0:
            # print '%d jobs remaining' % jobcount
            job = runlist.pop(0)
            jobnum  = job[0]
            runtime = float(job[1])
            if response[jobnum] == -1:
                response[jobnum] = thetime
            currwait = thetime - lastran[jobnum]
            wait[jobnum] += currwait
            if runtime > quantum:
                runtime -= quantum
                ranfor = quantum
                print '  [ time %3d ] Run job %3d for %.2f secs' % (thetime, jobnum, ranfor)
                runlist.append([jobnum, runtime])
            else:
                ranfor = runtime;
                print '  [ time %3d ] Run job %3d for %.2f secs ( DONE at %.2f )' % (thetime, jobnum, ranfor, thetime + ranfor)
                turnaround[jobnum] = thetime + ranfor
                jobcount -= 1
            thetime += ranfor
            lastran[jobnum] = thetime

        print '\n最终统计:'
        turnaroundSum = 0.0
        waitSum       = 0.0
        responseSum   = 0.0
        for i in range(0,len(joblist)):
            turnaroundSum += turnaround[i]
            responseSum += response[i]
            waitSum += wait[i]
            print '  Job %3d -- 响应时间: %3.2f  周转时间: %3.2f  等待时间: %3.2f' % (i, response[i], turnaround[i], wait[i])
        count = len(joblist)
        
        print '\n  平均 -- 响应时间: %3.2f  周转时间: %3.2f  等待时间: %3.2f\n' % (responseSum/count, turnaroundSum/count, waitSum/count)

    if options.policy != 'FIFO' and options.policy != 'SJF' and options.policy != 'RR': 
        print '错误: 策略 ', options.policy, ' 无效.'
        sys.exit(0)
else:
    print '计算每个作业的周转时间、响应时间和等待时间。'
    print '完成后，再次运行该程序，使用相同的参数，再附上 -c，为您提供答案。'
    print '您可以使用 -s <somenumber> 或您自己的工作列表（例如 -l 10,15,20）生成不同的题目。'
    print ''



