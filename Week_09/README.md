学习笔记

KMP字符串匹配算法：
假如匹配字符串P是否是字符串S的子串。

步骤一：
枚举字符串P的前缀，并且求得每个前缀字符串的最长前缀与最长后缀相等的长度，建立前缀表，前缀表第i个元素代表，前i-1个字符串最长公共前缀。

步骤二：
开始遍历字符串S,然后用P去与字符串S当前索引开始位置的字符串比较，出现不同的字符，那么根据索引，在前缀表当中寻找需要将字符串P哪个索引与当前不匹配的字符对齐，然后接着从这个字符开始继续匹配，直到找到了对应的字符串或者字符串S不足以继续遍历，则结束。
