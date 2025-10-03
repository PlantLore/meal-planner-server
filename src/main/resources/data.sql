INSERT INTO recipe (archived_recipe_id, calories, recipe_id, servings, creator_email, image, title) VALUES
    (
        null,
        600,
        1,
        4,
        'kennethdavis391@gmail.com',
        'https://i.imgur.com/8ewJgNK.png',
        'Spaghettie Bolognese'
    ),
    (
        null,
        400,
        2,
        2,
        'moberlies@gmail.com',
        '',
        'Bagels with Cream Cheese'
    ),
    (
        null,
        300,
        3,
        1,
        'kennethdavis391@gmail.com',
        '',
        'Avocado Toast'
    ),
    (
        null,
        500,
        4,
        3,
        'kennethdavis391@gmail.com',
        '',
        'Ham Sandwiches'
    ),
    (
        null,
        200,
        5,
        5,
        'kennethdavis391@gmail.com',
        '',
        'Ice Cream'
    ),
    (
        null,
        100,
        6,
        2,
        'kennethdavis391@gmail.com',
        '',
        'Fruit Salad'
    ),
    (
        6,
        150,
        7,
        2,
        'kennethdavis391@gmail.com',
        '',
        'Fruit Salad'
    ),
    (
        null,
        200,
        8,
        6,
        'kennethdavis391@gmail.com',
        '',
        'Garlic Bread'
    );

INSERT INTO step (ordinal, recipe_id, step_id, text) VALUES
    (1, 1, 1, 'Boil water'),
    (2, 1, 2, 'Cook pasta'),
    (3, 1, 3, 'Prepare sauce'),
    (4, 1, 4, 'Mix pasta and sauce'),
    (1, 2, 5, 'Slice bagel'),
    (2, 2, 6, 'Spread cream cheese'),
    (1, 3, 7, 'Toast bread'),
    (2, 3, 8, 'Slice avocado'),
    (3, 3, 9, 'Assemble toast'),
    (1, 4, 10, 'Slice bread'),
    (2, 4, 11, 'Add ham and condiments'),
    (3, 4, 12, 'Assemble sandwich'),
    (1, 5, 13, 'Scoop ice cream into bowl or cone'),
    (2, 5, 14, 'Add toppings if desired'),
    (1, 6, 15, 'Chop fruit'),
    (2, 6, 16, 'Mix fruit together in a bowl'),
    (1, 7, 17, 'Chop fruit'),
    (2, 7, 18, 'Mix fruit together in a bowl');

INSERT INTO grocery (grocery_id, name, section) VALUES
    (1, 'Spaghetti', 'INNER_AISLES'),
    (2, 'Ground Beef', 'MEAT'),
    (3, 'Tomato Sauce', 'INNER_AISLES'),
    (4, 'Bagels', 'BAKERY'),
    (5, 'Cream Cheese', 'DAIRY'),
    (6, 'Bread', 'BAKERY'),
    (7, 'Avocado', 'PRODUCE'),
    (8, 'Ham', 'MEAT'),
    (9, 'Lettuce', 'PRODUCE'),
    (10, 'Tomato', 'PRODUCE'),
    (11, 'Ice Cream', 'FROZEN_FOODS'),
    (12, 'Mixed Fruit', 'PRODUCE'),
    (13, 'Mustard', 'INNER_AISLES'),
    (14, 'Garlic Bread', 'FROZEN_FOODS');

INSERT INTO ingredient (grocery_id, ingredient_id, recipe_id, quantity, unit) VALUES
    (1, 1, 1, 400, 'grams'),
    (2, 2, 1, 250, 'grams'),
    (3, 3, 1, 1, 'cup'),
    (4, 4, 2, 2, ''),
    (5, 5, 2, 100, 'grams'),
    (6, 6, 3, 2, 'slices'),
    (7, 7, 3, 1, ''),
    (6, 8, 4, 2, 'slices'),
    (8, 9, 4, 100, 'grams'),
    (9, 10, 4, 2, 'slices'),
    (11, 11, 5, 200, 'grams'),
    (12, 12, 6, 150, 'grams'),
    (13, 13, 4, 1, 'tablespoon'),
    (12, 14, 7, 150, 'grams'),
    (10, 15, 7, 50, 'grams'),
    (14, 16, 8, 1, 'package');

INSERT INTO recipe_type (recipe_type_id, type) VALUES
    (1, 'Breakfast'),
    (2, 'Lunch'),
    (3, 'Dinner'),
    (4, 'Snack'),
    (5, 'Sweet Treat'),
    (6, 'Side'),
    (7, 'Fruit'),
    (8, 'Vegetable');

INSERT INTO recipe_recipe_types (recipe_recipe_id, recipe_types_recipe_type_id) VALUES
    (1, 3),
    (2, 1),
    (3, 1),
    (4, 2),
    (5, 5),
    (6, 7),
    (7, 7),
    (6, 4),
    (6, 6),
    (7, 4),
    (7, 6),
    (8, 6);

INSERT INTO meal_plan (created_on, end_date, meal_plan_id, start_date, creator_email) VALUES
    (DATEADD('DAY', -1, CURRENT_DATE), DATEADD('DAY', 1, CURRENT_DATE), 1, DATEADD('DAY', -1, CURRENT_DATE), 'kennethdavis391@gmail.com');

INSERT INTO meal_plan_day (day_date, meal_plan_day_id, meal_plan_id) VALUES
    (DATEADD('DAY', -1, CURRENT_DATE), 1, 1),
    (CURRENT_DATE, 2, 1),
    (DATEADD('DAY', 1, CURRENT_DATE), 3, 1);

INSERT INTO meal (meal_id, meal_plan_day_id, meal_type) VALUES
    (1, 1, 'BREAKFAST'),
    (2, 1, 'LUNCH'),
    (3, 1, 'DINNER'),
    (4, 1, 'SNACK'),
    (5, 1, 'SWEET_TREAT'),
    (6, 2, 'BREAKFAST'),
    (7, 2, 'LUNCH'),
    (8, 2, 'DINNER'),
    (9, 2, 'SNACK'),
    (10, 2, 'SWEET_TREAT'),
    (11, 3, 'BREAKFAST'),
    (12, 3, 'LUNCH'),
    (13, 3, 'DINNER'),
    (14, 3, 'SNACK'),
    (15, 3, 'SWEET_TREAT');

INSERT INTO meal_recipe (leftovers, meal_id, meal_recipe_id, recipe_id) VALUES
    (false, 1, 1, 2),
    (false, 2, 2, 4),
    (false, 3, 3, 1),
    (false, 4, 4, 6),
    (false, 5, 5, 5),
    (true, 6, 6, 2),
    (false, 7, 7, 4),
    (true, 8, 8, 1),
    (false, 8, 9, 8),
    (false, 10, 10, 5),
    (false, 11, 11, 3),
    (true, 12, 12, 4),
    (true, 13, 13, 1),
    (false, 14, 14, 6),
    (false, 15, 15, 5);