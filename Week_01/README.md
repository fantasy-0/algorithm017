学习小结	(2020.09.21 - 2020.09.27（week 01）)

一.通过本周看视频做题目，
了解到：栈、队列、跳表的实现原理，增删查时间复杂度。
学会了以下题目解题思路：
1.双指针的用法
（1）移动零：利用了快慢指针中间的间隔存储需要移动的0。
（2）接雨水：利用了双指针固定两边，从而确定低洼部分，累加所有低洼部分得出最后结果。
（3）最大盛水面积：利用了双指针固定两边，依次收敛，从而求得最大值。
（4）判断链表是否有环：利用快慢指针的相对速度不同，围绕同一个圈跑，肯定会相遇原理
（5）三数之和：首先得要使得数组有序，接着固定一边，另外两个指针固定两边类似最大盛水面积思路。
2.辅助栈
（1）两个栈实现队列：利用栈新进后出的特性，一个先进后出的栈再pop到另外一个栈最后实现了先进先出的队列；
（2）实现栈的方法并且新增一个方法常数时间下获取最大值：这个辅助栈用的非常巧妙，每次push一个元素都在辅助栈当中push一个元素与栈顶比较放入最大值，出栈主栈与辅助栈一起出即可）
3.找规律
（1）爬楼梯：可以爬一步或者两步，那么最后一次不走，就会剩下两种情况，最后一次爬两步情况有f(n-2)种，最后一次爬一步情况有f(n-1)种。
4.递归栈
（1）柱状图中最大矩形：首先得要想到枚举法，列举所有的宽形成的答案，列举所有的高形成的答案，从列举所有的高形成的答案可以看出来后面一个高找左边界，那么可以用左边缓存的值，而右边的边界即为小于栈顶的元素，这样可以用一个递增栈来模拟求得答案。
5.栈
（1）有效括号

