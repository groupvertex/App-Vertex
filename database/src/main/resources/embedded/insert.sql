INSERT INTO routes.route (id, name) VALUES (1, 'first');
INSERT INTO routes.route (id, name) VALUES (3, 'second');

INSERT INTO routes.waypoint (id, track_id, x, y, height, accuracy, get_time) VALUES (1, 1, 10, 25, 400, 5, now());
INSERT INTO routes.waypoint (id, track_id, x, y, height, accuracy, get_time) VALUES (2, 1, 50, 50, 405, 5, now());
INSERT INTO routes.waypoint (id, track_id, x, y, height, accuracy, get_time) VALUES (3, 3, 100, 250, 600, 3, now());
INSERT INTO routes.waypoint (id, track_id, x, y, height, accuracy, get_time) VALUES (4, 3, 110, 225, 700, 3, now());

INSERT INTO users.register_user (id, first_name, last_name, email, password) VALUES (1, 'Vasyl', 'Malik', 'leo124@bigmir.net', '123');
INSERT INTO users.register_user (id, first_name, last_name, email, password) VALUES (2, 'test', 'test', 'test@test.com', 'test');

INSERT INTO users.payment (id, user_id, amount) VALUES (1, 1, 1000);