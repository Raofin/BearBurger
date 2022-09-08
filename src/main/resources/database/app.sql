# drop BearBurger if exists
DROP SCHEMA IF EXISTS BearBurger;

# create database
CREATE DATABASE IF NOT EXISTS BearBurger;

# select the database
USE BearBurger;

# create users table
CREATE TABLE IF NOT EXISTS Users
(
    UserID      INT AUTO_INCREMENT PRIMARY KEY,
    Username    VARCHAR(15) NOT NULL UNIQUE,
    Email       VARCHAR(30) NOT NULL,
    Password    VARCHAR(62) NOT NULL,
    PhoneNumber VARCHAR(14) NOT NULL,
    Gender      VARCHAR(6)  NOT NULL,
    Spent       INT,
    Enabled     BOOL        NOT NULL,
    RegDate     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

# create roles table
CREATE TABLE IF NOT EXISTS Roles
(
    RoleID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    Role   VARCHAR(10)
);

# insert user data
INSERT IGNORE INTO Users (Username, Email, Password, PhoneNumber, Gender, Spent, Enabled)
VALUES ('Raofin', 'hello@raofin.net', '$2a$10$l1xCEl5Vns6NbmzeiRPWpuy7nWB9ikSI/A6z8SipFQoOKL8HojO.m', '+8801234567890', 'Male', 6801, TRUE),
       ('Bill Gates', 'billgates@outlook.com', '$2a$10$06Q7zDE.jtKiBsOFOCCileeVHhCaVPi8JMx6zaWWcj3E/JXdi17xy', '+6963343233159', 'Male', 9960, TRUE),
       ('Elon Musk', 'elonmusk@yahoo.com', '$2a$10$nwkSfj5g0.BZ8kJFIx99jOk9uIcMC.i9S2NRCrmyuR94CmlcezLqW', '+9668508170248', 'Male', 7856, FALSE),
       ('Jack Ma', 'jackma@gmail.com', '$2a$10$P9cJSj0euTBDp2kiBLzedep7LPjeon4G6pUFOrvy5P7xu9dKaMyUu', '+1667698473784', 'Male', 4567, TRUE),
       ('Steve Jobs', 'stevejobs@icloud.com', '$2a$10$drTpyeucMtB62LDVyVe8IOONRmd9gFkxSBWioAoFBeT6QPAU5uI06', '+1527475095845', 'Male', 421, FALSE),
       ('Jeff Bezos', 'jeffbezos@gmail.com', '$2a$10$a3EMVJdkZEVerGKgXK7LuOiU0ck5cH.iD5g3Xz/nMUnGmAVjjyNC.', '+8966295324845', 'Male', 2152, TRUE),
       ('Mark Zuckerberg', 'markzuckerberg@live.com', '$2a$10$GCaVUadVfLdrZEE7jn6iWu2bMpHpXn.X3DJSIqILslJNGvXZsynoq', '+2657146731697', 'Male', 3972, TRUE),
       ('Sundar Pichai', 'sundarpichai@gmail.com', '$2a$10$qojQDSjU7o.VOE4XmjfIxOanI4kFK3UmN9hoaxZPD.PVbOOCk/nRC', '+9815680737969', 'Male', 1546, FALSE),
       ('1111', '1111@1111.com', '$2a$10$w9byGF9YAD0U29wQdNpICehY.nBHBxZ47J4tTO8Mq46h9OFI2iMMO', '+4795131456789', 'Male', 68, TRUE),
       ('admin', 'admin@email.com', '$2a$10$3l0p7n2pIIykRYaPsPbvt.8y60kvyNF9E7Q6e21sMi7tBRPqL8zvS', '+6478912356147', 'Male', 0, TRUE);

# insert user data
INSERT IGNORE INTO Roles (UserID, Role)
VALUES (1, 'CUSTOMER'),
       (1, 'ADMIN'),
       (2, 'CUSTOMER'),
       (2, 'ADMIN'),
       (3, 'CUSTOMER'),
       (4, 'CUSTOMER'),
       (5, 'CUSTOMER'),
       (5, 'ADMIN'),
       (6, 'CUSTOMER'),
       (7, 'CUSTOMER'),
       (8, 'CUSTOMER'),
       (9, 'CUSTOMER'),
       (9, 'ADMIN'),
       (10, 'CUSTOMER'),
       (10, 'ADMIN');

# create foods table
CREATE TABLE IF NOT EXISTS Foods
(
    FoodID      INT AUTO_INCREMENT PRIMARY KEY,
    Category    VARCHAR(30) NOT NULL,
    Title       VARCHAR(100) NOT NULL UNIQUE,
    Description TEXT        NOT NULL,
    Price       INT         NOT NULL
);

# create users table
CREATE TABLE IF NOT EXISTS Comments
(
    CommentID INT AUTO_INCREMENT PRIMARY KEY,
    ParentID  INT         NOT NULL,
    FoodID    INT         NOT NULL,
    PostedBy  VARCHAR(30) NOT NULL,
    Comment   TEXT        NOT NULL,
    PostDate  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

# insert food data
INSERT IGNORE INTO Foods (Category, Title, Description, Price)
VALUES ('Burger', 'Cheese Burger', 'Prepared with beef patty, cheese, burger sauce, pickles & onion', 650),
       ('Burger', 'Bacon Cheese Burger', 'Prepared with beef patty, 2 slices cheese, bacon & burger sauce', 500),
       ('Burger', 'Double Cheese Burger', 'Prepared with 2 beef patties, double cheese, burger sauce & onion', 640),
       ('Burger', 'Lil Smoke', 'Prepared with beef patty, cheese, bbq sauce, burger sauce, pickles & onion', 160),
       ('Burger', 'Beef Smoke', 'Prepared with 2 beef patties, 2 slices cheese, bbq sauce, burger sauce & onion', 280),
       ('Burger', 'Juicy Burger', 'Prepared with potato juice, beef patties, double cheese & burger sauce', 960),
       ('Pizza', 'BBQ Chicken Pizza', 'Topped with grilled chicken, bbq sauce & mozzarella cheese', 240),
       ('Pizza', 'Chicken Meatball Pizza', 'Topped with chicken meatball, tomato sauce & mozzarella cheese', 960),
       ('Pizza', 'Chicken Tikka Pizza', 'Topped with chicken tikka, tomato sauce & mozzarella cheese', 350),
       ('Pizza', 'Beef Meatball Pizza', 'Prepared with frank sausage, bacon, scallion, sauce & cheddar cheese', 560),
       ('Pizza', 'Vegetable Pizza', 'Topped with capsicum, mushroom, sweet corn, onion & black olive', 480),
       ('Pizza', 'Chicken Chunky Pizza', 'Topped with black olive, tomato, capsicum & green chili', 510),
       ('Salad', 'Cashewnut Salad', 'Topped with cashew nout and veggies', 310),
       ('Salad', 'Seafood Salad', 'Topped with seafood and lots of veggies and virgin olive oil', 360),
       ('Salad', 'Grilled Chicken Salad', 'Topped with chicken and secret spice ', 310),
       ('Salad', 'Russian Salad', 'Authentic russian taste with lots of veggies and secret sauce', 370),
       ('Salad', 'Korean Beef Salad', 'Made with beed in korean spice and sauce', 560),
       ('Pasta', 'Bitch Lasagna', 'Baked casserole made with wide flat pasta and layered with fillings such as ragú.', 996),
       ('Pasta', 'Ovenbaked Pasta', 'Topped with black olive, chicken, capsicum & green chili', 450),
       ('Pasta', 'BBQ Grill Chicken Pasta', 'Topped with grilled chicken, bbq sauce & mozzarella cheese', 340),
       ('Pasta', 'Seafood Pasta', 'Topped with seafood & mushroom', 350),
       ('Pasta', 'American Mac & Cheese', 'Topped with macarony & mozzarella cheese', 560),
       ('Drinks', 'Lemonade', 'Taste of fresh lemon and freshness', 110),
       ('Drinks', 'Iced lemon Tea', 'Lemon tea but with chilled ice', 200),
       ('Drinks', 'Lemon lassi', 'Taste of lassi with tanginess of lemon', 170),
       ('Drinks', 'Milk Shake', 'Taste of heavy cream and milk', 140),
       ('Drinks', 'Mango Smoothie', 'Tate of mangoes infused with cream and milk', 270),
       ('Coffee', 'Espresso', 'Shots of pure coffee', 120),
       ('Coffee', 'Cappuccino', 'Shots of pure coffee induced milk', 260),
       ('Coffee', 'Americano', 'SHots of pure Coffee in American style ', 310),
       ('Coffee', 'Latte', '30% coffee with heavy milk ', 370),
       ('Desert', 'Brownie', 'Mix of chocolate and magic', 130),
       ('Desert', 'Red Velvet', 'Magic of bakery in red color', 260),
       ('Desert', 'Choco Fudge', 'Chocolate cheese and creaminess ', 190),
       ('Desert', 'Oreo and Cheese', 'Crunchy oreo crust and creamy cheese feeling', 190),
       ('Desert', 'Blueberry Cheese Dip', 'Mix of blueberry cheesy feeling', 170),
       ('Sides', 'Medium French Fry', 'Delicious french fry in medium', 90),
       ('Sides', 'Large French Fry', 'Delicious french fry in large', 110),
       ('Sides', 'Chicken Fingers', 'Chicken fried in finger sized', 130),
       ('Sides', 'Naga Drumsticks', 'Soft spicy chicken with crunchy outer', 120);

# insert comment data
INSERT IGNORE INTO Comments (CommentID, ParentID, FoodID, PostedBy, Comment, PostDate)
VALUES (1, 0, 1, 'Raofin', 'I have to say, I enjoyed every single bite of the meal.', '2022-07-17 22:27:04'),
       (2, 1, 1, 'Bill Gates',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eum maxime modi necessitatibus rem sed. Ad consequuntur dolorem nobis sequi tempora?',
        '2022-07-17 22:28:28'),
       (3, 2, 1, 'Raofin', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Totam, unde!',
        '2022-07-17 22:29:36'),
       (4, 2, 1, 'Bill Gates', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.', '2022-07-17 22:30:55'),
       (5, 0, 1, 'Elon Musk', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate, sequi.',
        '2022-07-17 22:31:48'),
       (6, 4, 1, 'Steve Jobs', 'Lorem ipsum dolor sit amet, consectetur.', '2022-07-17 22:32:46'),
       (7, 0, 1, 'Jeff Bezos',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias asperiores cumque dolore, harum iure necessitatibus perferendis quasi sequi suscipit tempore? Aperiam culpa delectus ducimus inventore nam possimus praesentium provident quaerat quas, quidem quisquam, recusandae sunt suscipit totam ullam vitae, voluptatibus.',
        '2022-07-17 22:35:34');