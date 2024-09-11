## UI-тесты для веб-приложения "Яндекс.Самокат". Проект по автоматизированному тестированию/
Яндекс.Самокат — сервис, который позволяет арендовать электрический самокат на несколько дней.

## Задачи:
1. Изучить тестовые сценарии.
   
<details>
<summary> Тестовые сценарии </summary> 
1. *Выпадающий список в разделе «Вопросы о важном».*
Нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
   
2. *Заказ самоката. Весь флоу позитивного сценария.* Есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу. 
Из чего состоит позитивный сценарий:
 - Нажать кнопку «Заказать». На странице две кнопки заказа.
 - Заполнить форму заказа.
 - Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.

***
</details>

2. Написать тесты с разными данными: минимум два набора.

## Проделанная работа:
- собран Maven-проект в IntelliJ IDEA с использованием Java 11 и подключением JUnit 4, Selenium;
- изучены тестовые сценарии и по ним написаны автотесты - проверен выпадающий список, заказ самоката;
- тест написан для последних версий браузеров Google Chrome и Mozilla Firefox.
