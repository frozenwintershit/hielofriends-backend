INSERT INTO penguin_plushes (id, model, price, currency, available_stock) 
VALUES ('11111111-1111-1111-1111-111111111111', 'Pingüino Emperador', 15990.0, 'CLP', 10)
ON CONFLICT (id) DO NOTHING;

INSERT INTO penguin_plushes (id, model, price, currency, available_stock) 
VALUES ('22222222-2222-2222-2222-222222222222', 'Pingüino Adelia', 12990.0, 'CLP', 15)
ON CONFLICT (id) DO NOTHING;

INSERT INTO penguin_plushes (id, model, price, currency, available_stock) 
VALUES ('33333333-3333-3333-3333-333333333333', 'Pingüino Papúa', 13990.0, 'CLP', 8)
ON CONFLICT (id) DO NOTHING;

INSERT INTO penguin_plushes (id, model, price, currency, available_stock) 
VALUES ('44444444-4444-4444-4444-444444444444', 'Pingüino Azul', 11990.0, 'CLP', 25)
ON CONFLICT (id) DO NOTHING;