# Sparse Arrays


> HackerRank - Data Structures 
> Difficulty: Medium  
> [🔗 View Problem on HackerRank](https://www.hackerrank.com/challenges/sparse-arrays/problem?isFullScreen=true)


## Бодлогын өгүүлбэр
Та олон тооны оролтын мөр болон асуулгын мөрүүд-ийн цуглуулгатай байна. Асуулгын мөр бүрийн хувьд, оролтын мөрүүдийн жагсаалтад хэдэн удаа давтагдсаныг тодорхойл. Үр дүнг массиваар буцаана.

Жишээ
stringList = ['aba', 'baba', 'aba', 'xzxb']
queries = ['aba', 'xzxb', 'ab']

'aba' нь 2 удаа, 'xzxb' нь 1 удаа, 'ab' нь 0 удаа давтагдсан байна. Асуулга бүрийн хувьд буцаах массивд элемент нэмнэ: [2, 1, 0].

Функцийн тайлбар
matchingStrings функцийг дараах параметртэйгээр гүйцээ:

stringList: хайх мөрүүдийн массив
queries: асуулгын мөрүүдийн массив
Буцах утга

int[]: асуулга бүрийн үр дүн
Оролтын формат
Эхний мөрөнд stringList-ийн хэмжээ болох n бүхэл тоо байна.
Дараагийн n мөр тус бүр нь мөр байна.
Дараагийн мөрөнд queries-ийн хэмжээ болох q бүхэл тоо байна.
Дараагийн q мөр тус бүр нь мөр байна.

Хязгаарлалт
1≤n,q≤1000
1≤∣strings[i]∣,∣queries[i]∣≤20
Жишээ оролт 1
4
aba
baba
aba
xzxb
3
aba
xzxb
ab
Жишээ гаралт 1

2
1
0
Тайлбар 1

Энд "aba" нь эхний болон гурав дахь мөрөнд хоёр удаа давтагдсан байна. "xzxb" мөр нь дөрөв дэх мөрөнд нэг удаа давтагдсан байна, харин "ab" нь огт давтагдаагүй байна.

Жишээ оролт 2
3
def
de
fgh
3
de
lmn
fgh
Жишээ гаралт 2

1
0
1
Жишээ оролт 3
13
abcde
sdaklfj
asdjf
na
basdn
sdaklfj
asdjf
na
asdjf
na
basdn
sdaklfj
asdjf
5
abcde
sdaklfj
asdjf
na
basdn
Жишээ гаралт 3

1
3
4
3
2
![alt text](<Screenshot 2025-06-10 145753.png>)