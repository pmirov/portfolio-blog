INSERT INTO users (username, email, password, role, telegram_id, profile_image_url) VALUES
                                                                                        ('john_doe', 'john@example.com', 'hashed_password_1', 'USER', '123456789', 'http://example.com/images/john.jpg'),
                                                                                        ('jane_smith', 'jane@example.com', 'hashed_password_2', 'USER', '987654321', 'http://example.com/images/jane.jpg'),
                                                                                        ('admin_user', 'admin@example.com', 'hashed_password_3', 'ADMIN', NULL, 'http://example.com/images/admin.jpg');

INSERT INTO projects (user_id, title, description, is_public, github_url) VALUES
                                                                              (1, 'Project Alpha', 'Description of Project Alpha', TRUE, 'http://github.com/user/project-alpha'),
                                                                              (1, 'Project Beta', 'Description of Project Beta', FALSE, 'http://github.com/user/project-beta'),
                                                                              (2, 'Project Gamma', 'Description of Project Gamma', TRUE, 'http://github.com/user/project-gamma');

