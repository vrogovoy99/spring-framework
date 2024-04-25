INSERT INTO regions (region_id, region, country)
VALUES (1, 'Southwest', 'United States'),
       (2, 'Northeast', 'United States'),
       (3, 'Northwest', 'United States'),
       (4, 'Central', 'Asia'),
       (5, 'East Asia', 'Asia'),
       (6, 'Quebec', 'Canada'),
       (7, 'Nova Scotia', 'Canada')
    ON CONFLICT DO NOTHING;