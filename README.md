# MyParking
Android Programming - Project

Проектот се состои од
1. DBHelper - класа каде што се методите за манипулирање со датабазата
2. MainActivity - Формата за логирање на постоечки корисник. Се внесуваат корисничко име и лозинка. Се проверува дали сите полиња се потполнети, потоа се проверува дали корисничкото
име е валидно и на крај дали внесениот пасворд е точен.
3. Registration - Форма за регистрација на нов корисник. Се внесува име, презиме, корисничко име и лозинка. Се проверува дали сите полиња се потполнети. Се проверува дали внесеното
корисничко име е зафатено. Се проверува дали лозинката е минимум 8 карактери. При успешна регистрација се испишува порака за успех. 
4. Cities - Се прикажани сите градови каде што има опција да се паркира.
5. Reservation - 2 layouts за portrait и landscape. Се одбира датум и време. Се проверува дали корисникот има 3 активни резервации. Се проверува дали има резервација во тој датум и во тоа време. 
6. Parking Places - Се одбира паркинг простор. Во зеленото квадратче се дадени слободните места, во црвеното зафатените. Овие 2 бројчиња се пресметуваат, не се чуваат во база.
7. Confirmation - Успех. 2 layouts за portrait и landscape. 
8. QRCode - Се прикажува QR кодот за резервацијата. 
9. My reservations - Се прикажуваат 3 активни резервации. Секој корисник може да има максимум 3 активни резервации. 