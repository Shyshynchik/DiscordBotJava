# Список задач на будущее

Далее представляется список задач по развитию проекта. Он будет дополняться по мере развития проекта.

---
### TODO

- [ ] **Добавить Систему Логирования**: Внедрить надежную систему логирования для записи и хранения логов в файлах.

- [ ] **Начать использовать docker**:
    - Создать Dockerfile для java.
    - Создать docker-compose файл для управления сервисами.

- [ ] **Интегрировать Проигрывание Музыки**:
    - Реализовать команду `!play` для проигрывания музыки.
    - Добаить функционал воспроизведения музыки. [Вариант реализации](https://docs.discord4j.com/music-bot-tutorial/)

- [ ] **Информация о Погоде**:
    - Реализовать команду `!weather` для получения данных о погоде.
    - Создать функционал для отображения информации о погоде [Ключ лежит тут](https://openweathermap.org/).

- [ ] **Документация для Интерфейсов**:
    - Документировать контракты и интерфейсы, используемые в проекте.
---
### Done
- [x] **Изменил команду hello, чтобы она воспринимала несколько строк**
- [x] **Заменить \<Dto> на букву соответсвуюущую правилам Oracle**:
    - Удалить вхождения \<Dto> и заменить их соответствующими правилами Оракла.
    - **Заменил \<Dto> на \<T>**