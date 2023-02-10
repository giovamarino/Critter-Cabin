BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,first_time,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_USER');
INSERT INTO users (username,password_hash,first_time,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_ADMIN');

insert into pets (pet_image, name, type, age, gender, weight, breed, description, adopted)
values
('https://res.cloudinary.com/difcq8eki/image/upload/v1675993120/smalljayna_u68dnq.jpg','Jayna', 'dog', 1, 'female', 9, 'dachshund', 'Looking for a home for this little abandoned guy', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887638/pexels-helena-lopes-1938126_awqfei.jpg', 'Fido', 'dog', 3, 'male', 35, 'mixed', 'Sweet dog who loves people, squirrels, and the mailman', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888119/pexels-ylanite-koppens-612813_i6vpcl.jpg', 'Frank', 'dog', 2, 'male', 40, 'mixed', 'This guy will love you and protect your home forever!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675892812/pexels-vadim-b-127028_mbkijo.jpg', 'Peach', 'cat', 1, 'female', 5, 'scottish fold mix', 'Just a baby', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675867797/Dogs/golden3_pvcuzs.jpg', 'Angus', 'Dog', 10, 'Male', 60, 'Golden Retriever', 'Your next best friend cannot wait to meet you!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979297/Dogs/smudge3_dnohly.jpg', 'Smudge', 'Cat', 4, 'Male', 18, 'Manx', 'Looking for someone to feed me and love me!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137381/Dogs/greyhound_iukaja.jpg', 'Lulu', 'Dog', 3, 'Female', 30, 'Italian Greyhound', 'A running buddy who also enjoys snuggling!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675955656/Dogs/aussiedoodle-adult_pvuz0v.jpg', 'Penelope', 'Dog', 0, 'Female', 15, 'AussieDoodle', 'I do not shed and am passionate about squeaky toys!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957124/pexels-enrique-11010200_ad38ca.jpg', 'Peanut', 'Guinea Pig', 1, 'Male', 2, 'American Guinea Pig', 'I love lettuce, hiding in small boxes, and when you scratch my forehead!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957273/pexels-alexandru-rotariu-733416_npx3gp.jpg', 'Cookie', 'Dog', 3, 'Female', 55, 'Pit Bull Mix', 'I love lettuce, hiding in small boxes, and when you scratch my forehead!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957431/pexels-james-frid-1750542_suiunv.jpg', 'Loki', 'Dog', 2, 'Male', 22, 'Jack Russel', '"Plays well with others and very active!"', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675978711/whitecatsmale3_dqaar5.jpg', 'Elsa', 'Cat', 7, 'Female', 14, 'Turkish Angora', 'Apex predator disguised as a fluffy white cloud.', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980287/Dogs/spike3_x0cttv.jpg', 'Spock', 'Dog', 5, 'Male', 45, 'Pit Bull Mix', 'Just waiting for you to throw me a ball!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980579/Dogs/heeler2_utb2i1.jpg', 'Ella', 'Dog', 4, 'Female', 42, 'Blue Heeler', 'I am very protective over the people I love and do not want to live in a house with children.', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675978693/husky3_bwycxj.jpg', 'Seth', 'Dog', 8, 'Male', 70, 'Husky', 'Retired guard dog looking for a loving home.', false);

insert into pet_images (pet_image, is_primary, pet_id)
values
-- Jayna
('https://res.cloudinary.com/difcq8eki/image/upload/v1675993120/smalljayna_u68dnq.jpg', true, 1),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675880125/pexels-dominika-roseclay-4148015_b1wwb8.jpg', false, 1),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675879644/pexels-dominika-roseclay-4318208_whrvqq.jpg', false, 1),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675879456/Saved%20Pictures/pexels-dominika-roseclay-4884404_1_unprof.jpg', false, 1),
-- Fido
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887638/pexels-helena-lopes-1938126_awqfei.jpg', true, 2),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887627/pexels-blue-bird-7210704_bbbygn.jpg', false, 2),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887636/pexels-blue-bird-7210618_acuj8s.jpg', false, 2),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675960171/siwvsqce0hcmqhvlktsv.jpg', false, 2),
-- Frank
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888119/pexels-ylanite-koppens-612813_i6vpcl.jpg', true, 3),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888117/pexels-ylanite-koppens-2115604_uo6vpr.jpg', false, 3),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675982679/Dogs/lastspike_yhbjhg.jpg', false, 3),
-- Peach
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675892812/pexels-vadim-b-127028_mbkijo.jpg', true, 4),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979547/Dogs/kiten3_xiuxb9.jpg', false, 4),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979539/Dogs/kitten2_itoafq.jpg', false, 4),
-- Angus
('https://res.cloudinary.com/difcq8eki/image/upload/v1675867797/Dogs/golden3_pvcuzs.jpg', true, 5),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675867790/Dogs/golden2_tqekf5.jpg', false, 5),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675867780/Dogs/golden1_sdih1a.jpg', false, 5),
-- Smudge
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979297/Dogs/smudge3_dnohly.jpg', true, 6),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979289/Dogs/smudge2_oe91vl.jpg', false, 6),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979284/Dogs/smudge1_mjj7zm.jpg', false, 6),
-- Lulu
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137381/Dogs/greyhound_iukaja.jpg', true, 7),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675982164/Dogs/greyhound3_by7jco.jpg', false, 7),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675982157/Dogs/greyhound2_npoy31.jpg', false, 7),

-- Penelope
('https://res.cloudinary.com/difcq8eki/image/upload/v1675955656/Dogs/aussiedoodle-adult_pvuz0v.jpg', true, 8),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675981886/Dogs/aussie_n888x6.webp', false, 8),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675981880/Dogs/aussie3_olb0m7.jpg', false, 8),
-- Peanut
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957124/pexels-enrique-11010200_ad38ca.jpg', true, 9),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675981203/Dogs/gpig2_kxfog7.jpg', false, 9),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675981197/Dogs/gpig_baopzc.jpg', false, 9),
--Cookie
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957273/pexels-alexandru-rotariu-733416_npx3gp.jpg', true, 10),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980829/Dogs/cookie2_bmbplt.jpg', false, 10),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980835/Dogs/cookie3_opiaxa.jpg', false, 10),
--Lokie
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957431/pexels-james-frid-1750542_suiunv.jpg', true, 11),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137374/Dogs/russelterrier_hamxuo.jpg', false, 11),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675979918/Dogs/jackrussel3_c721pt.jpg', false, 11),
-- Elza
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675958333/pexels-phiraphon-srithakae-15317706_exlzs9.jpg', false, 12),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675978704/whiteCatSmall_fyfbtz.jpg', false, 12),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675978711/whitecatsmale3_dqaar5.jpg', true, 12),
-- Spock
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980287/Dogs/spike3_x0cttv.jpg', true, 13),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980309/Dogs/spike2_gq26tf.jpg', false, 13),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980302/Dogs/spiketall_ehexrv.jpg', false, 13),
-- Ella
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980579/Dogs/heeler2_utb2i1.jpg', true, 14),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980574/Dogs/heeler_z4njhx.jpg', false, 14),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675980584/Dogs/heeler3_qv8pqp.jpg', false, 14),
-- Seth
('https://res.cloudinary.com/difcq8eki/image/upload/v1675978693/husky3_bwycxj.jpg', true, 15),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675956277/Dogs/husky2_wh38hc.jpg', true, 15),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675981575/Dogs/husky4_gfwvsy.jpg', true, 15);




COMMIT TRANSACTION;
