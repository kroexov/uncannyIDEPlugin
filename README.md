# Uncanny IntelliJ Idea plugin
## By Ilya Korekhov M33031
### 1. [Теория по плагинам](#Теория)
### 2. [Создание плагина](#Разработка)
### 3. [Функционал плагина](#Функционал)
### Этот плагин предназначен для поиска всех ошибок в вашем коде и отображения их количества с помощью известного мема. Таким образом вы не только сможете оценить масштаб проблемы, но и немного расслабиться, даже если в вашей программе очень много ошибок
### Плагин открывается сочетанием клавиш Ctrl + \ , затем Ctrl + E
# Теория

## Плагин - это расширение функциональных возможностей или интерфейса для IDE, по сути плагины являются основным средством расширения для всех IDE.
### Я выбрал создание плагина для IntelliJ IDEA, в первую очередь по причине легкости создания и большому количеству гайдов в интернете.
### Главные инструменты для функционала плагина - Actions, которые можно привязать к какой-либо клавишной комбинации и привязать к ним практически любое действие. В моём случае я использовал встроенный инструмент поиска ошибок, чтобы вставить количество этих ошибок и необходимый мем в результат работы, а именно MessageDialog, который открывается через Action, привязанный к необходимому мне сочетанию клавиш

# Разработка

Создание нового плагина
![image](https://user-images.githubusercontent.com/79146846/205722137-b560693d-3768-468c-93b2-9ef2c10800c2.png)

Регистрация Action и назначение сочетания клавиш
![image](https://user-images.githubusercontent.com/79146846/205722255-86d2886e-baa7-4b0b-aa2b-b23092225138.png)

Реализация действия при вызове Action и работа с virtual files
![image](https://user-images.githubusercontent.com/79146846/205722314-640531dd-11ff-4b82-888e-14babc684d8c.png)

# Функционал

Меньше 2 ошибок
![image](https://user-images.githubusercontent.com/79146846/205723228-aaa1e778-ce0c-425a-9d0d-89ada71aa235.png)
Меньше 5 ошибок
![image](https://user-images.githubusercontent.com/79146846/205723172-0a90e9fd-7bd2-48f2-a700-d4a271171884.png)
Меньше 10 ошибок
![image](https://user-images.githubusercontent.com/79146846/205723123-45d18c07-b891-443c-93ba-f5857eaef7fd.png)
Меньше 20 ошибок
![image](https://user-images.githubusercontent.com/79146846/205723055-47c7e428-c8ae-4294-aa49-2062469ee926.png)
Меньше 50 ошибок
![image](https://user-images.githubusercontent.com/79146846/205722988-b3808e0b-6892-4e80-be60-5bc8e40a4a0f.png)
От 50 ошибок и больше
![image](https://user-images.githubusercontent.com/79146846/205722920-bbff6630-698b-4fe9-8c01-8f472c6a3261.png)
