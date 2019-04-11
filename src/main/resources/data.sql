insert into CATEGORY  (ID , NAME, DESCRIPTION ) values 
(1, 'Inne','Wszystkie pozostałe'),
(2, 'Elektronika','Komputery, telewizory i telefony'),
(3, 'Motoryzacja','Samochody, motocykle i części'),
(4, 'Wyposażenie biura','Biurka, krzesła i tapczany'),
(5, 'Podłogi','Panele, deski i płytki'),
(6, 'Rozrywka','Gry, wyjazdy i turystyka');

insert into OFFER (ID ,DESCRIPTION ,IMG_URL ,PRICE ,TITLE ,CATEGORY_ID ) values 
(1, 'Bardzo duży telewizor w bardzo absurdalnej cenie','http://blabla2.jpg', 4999,'Telewizor Philips 49 cali',2),
(2, 'Brzydki laptop w dobrej cenie' , 'http://blabla2.jpg' , 2800 , 'Laptop Samsung', 2),
(3, 'Samochód roku 2018' , 'http://blabla2.jpg' , 850000 , 'Skoda Octavaia' ,3),
(4, 'Motocykl na każdą trasę' , 'http://blabla2.jpg' , 60000, 'BMW R1200GS', 3),
(5, 'Wygodny fotel obrotowy do całodziennego siedzenia przy komputerze' , 'http://blabla2.jpg' , 500 , 'Fotel biurowy PX500', 4),
(6, 'Biurko z paździerza, używane. Okleina dąb sonoma' , 'http://blabla2.jpg' , 250, 'Biurko no-name', 4),
(7, 'Deska barlinecka - niezwykłe wzornictwo, Klasa AC5, Gwarancja 10lat' , 'http://blabla2.jpg' , 85, 'Deska warstwowa T599', 5),
(8, 'Panele podłogowe najtańsze do mieszkania na wynajem' , 'http://blabla2.jpg' , 45, 'Panel podłogowy PTY-2325', 5),
(9, 'Gra komputerowa na długie godziny użerania się z innymi ludźmi' , 'http://blabla2.jpg' , 120, 'Gra no-name', 6),
(10, 'Tygodniowy pobyt w podrzędnym ośrodku turystycznym na ' , 'http://blabla2.jpg' , 3000, 'Niezapomniane wczasy dla dwojga', 6);