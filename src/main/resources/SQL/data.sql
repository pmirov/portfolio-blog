INSERT INTO users (username, email,  role, telegram_id, profile_image_url) VALUES
                                                                                        ('john_doe', 'john@example.com',  'USER', '123456789', 'http://example.com/images/john.jpg'),
                                                                                        ('jane_smith', 'jane@example.com',  'USER', '987654321', 'http://example.com/images/jane.jpg'),
                                                                                        ('admin_user', 'admin@example.com',  'ADMIN', NULL, 'http://example.com/images/admin.jpg');

INSERT INTO projects (user_id, title, description, is_public, github_url) VALUES
                                                                              (1, 'Project Alpha', 'Description of Project Alpha', TRUE, 'http://github.com/user/project-alpha'),
                                                                              (1, 'Project Beta', 'Description of Project Beta', FALSE, 'http://github.com/user/project-beta'),
                                                                              (2, 'Project Gamma', 'Description of Project Gamma', TRUE, 'http://github.com/user/project-gamma');

INSERT INTO diary_entries (user_id, title, content, is_public)
VALUES
    (1, 'День первый', 'Сегодня я начал вести дневник. Всё новое ощущается странным и захватывающим.', TRUE),
    (1, 'Мои мысли', 'Душевные переживания не дают покоя, но я пытаюсь найти светлые моменты в каждом дне.', TRUE),
    (1, 'Новые горизонты', 'Сегодня мне удалось сделать маленький шаг к большой цели. Жизнь прекрасна!', TRUE);