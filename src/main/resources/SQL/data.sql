INSERT INTO users (username, email,  role, telegram_id, profile_image_url) VALUES
                                                                                        ('john_doe', 'john@example.com',  'USER', '123456789', 'http://example.com/images/john.jpg'),
                                                                                        ('jane_smith', 'jane@example.com',  'USER', '987654321', 'http://example.com/images/jane.jpg'),
                                                                                        ('admin_user', 'admin@example.com',  'ADMIN', NULL, 'http://example.com/images/admin.jpg'),
                                                                                        ('ivan_petrov', 'ivan.petrov@example.com', 'USER', '1122334455', 'http://example.com/images/ivan.jpg'),
                                                                                        ('elena_kuznetsova', 'elena.kuznetsova@example.com', 'USER', '5566778899', 'http://example.com/images/elena.jpg'),
                                                                                        ('super_admin', 'superadmin@example.com', 'ADMIN', NULL, 'http://example.com/images/superadmin.jpg');

INSERT INTO projects (user_id, title, description, is_public, github_url) VALUES

                                                                              (2, 'Система рекомендаций книг', 'Публичный проект по разработке системы рекомендаций книг на основе предпочтений пользователя.', TRUE, 'http://github.com/elena/book-recommendation'),
                                                                              (3, 'Автоматизация бухгалтерии', 'Приватный проект для автоматизации бухгалтерских операций в малом бизнесе.', FALSE, 'http://github.com/ivan/accounting-automation'),
                                                                              (4, 'Платформа онлайн-обучения', 'Публичная платформа для проведения онлайн-курсов и вебинаров.', TRUE, 'http://github.com/superadmin/online-learning'),
                                                                              (1, 'Project Alpha', 'Description of Project Alpha', TRUE, 'http://github.com/user/project-alpha'),
                                                                              (1, 'Project Beta', 'Description of Project Beta', FALSE, 'http://github.com/user/project-beta'),
                                                                              (2, 'Project Gamma', 'Description of Project Gamma', TRUE, 'http://github.com/user/project-gamma');

INSERT INTO diary_entries (user_id, title, content, is_public)
VALUES
    (1, 'День первый', 'Сегодня я начал вести дневник. Всё новое ощущается странным и захватывающим.', TRUE),
    (1, 'Мои мысли', 'Душевные переживания не дают покоя, но я пытаюсь найти светлые моменты в каждом дне.', TRUE),
    (1, 'Новые горизонты', 'Сегодня мне удалось сделать маленький шаг к большой цели. Жизнь прекрасна!', TRUE),
    (2, 'Первый день на новом проекте', 'Сегодня начал работать над системой рекомендаций книг. Очень интересно!', TRUE),
    (3, 'Технические сложности', 'Возникли проблемы с интеграцией бухгалтерского ПО, но я уверен, что скоро решу.', FALSE),
    (4, 'Запуск платформы', 'Платформа онлайн-обучения успешно запущена, первые пользователи уже зарегистрировались.', TRUE);
