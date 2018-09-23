# Családi TODO
Alkalmazás fejlesztés C beadandó (Horváth Kristóf, Nemes László) gyakorlatvezető: Rakonczai Sándor.

Horváth Kristóf : BQFD6W
Nemes László : RVR55V

Feladat: Családi TODO

## Feladat Funkcionális Követelményei:
 1. Biztosítani kell a megfelelő autentikációt, első körben regisztráció, majd a belépési felület és a kijelentkezés visszajelzésére szükséges felület.
	1. Reakciók: A regisztráció folyamáán a kitöltött mezők adatait ellenőrizni kell bozonyos esetekben, hogy megfelelő adatot adott meg a regisztrálni kívánó felhasznló.
	2. Például: Email cím helyes szintaktika.
2. Bejelentkezésnél megfelelő felhasználó és jeszó párt ad meg bejelentkezéskor, ha hibás valamely adat jelezni kell a felhasználó felé.
2. Bejelentkezést követően a teendők listáját látja a felhasználó, szűrési lehetőség biztosítása ünmagára és más családtagokra.
	1. Reakció: Bejeletkezést követően a felhasználó a teendők litáját látja, amin szűréseket végezhet (pl: Saját feladataira szűr, családtag feladataira szűr)
3. Biztosítani kell a feladatok felvételét és törlését.
	1. Reakció: Felhasználónak képesnek kell lennie Feladat felvételére és törlésére is.
4. A teendő listán biztosítani kell alapvető műveleteket: Listázás, Keresés, Megtekint, Visszajelzés.
	1. Reakció: A feladatokon lehetőságet kell biztosítani különböző módosítások végrehajtására, állapot jelzésére -> (aktív,elkészült)
5. A fent említett műveletek végrehajtás után egyértelműnek kell lennie a többi felhasználó számára is. (Ha elvégzett a feladat legyen egyértelmű.)
	1. Reakció: A fent említett módon a feladatok állapotának és annak változásának egyértelműnek és jól láthatónak kell lennie.

## Feladat nem funkcionális követelményei:
 - Letisztult és egyértelmű felhasználói felület, ami mindenki számára könnyen áttekinthető.
 - Termék követelményei: Webes felületen futó alkalmazás, megfelelő válaszidővel és gyorsaséggal megbízhatóan használhatónak kell lennie.
 - Amelyet Java Sprig Boot, Java, JavaScript, Angular, HTML+CSS felhasználásaval készül el.
 - Szervezeti követelmény: Az alkalmazásnak a felnt említett fnkcionális követelméyneknek eleget kell tennie.
 - Külső Követelmény: A felhasználók adatainak megfelelő menedzselése, és biztosítása, hogy ne kerüljön illetéktelen kezekbe.
	
Szakterületi fogalomjegyzék:
	Felhasználó: Egy családtag aki regisztrált az alkalmazásba, minden ilyen felhasználó azonos rangú.
	Hozzáadás: Új feladat felvétele a litába, ami végrehajtásra vár.
	Feladat: Kiírt vegrajtásra váró cselekmény.
	Teendő: Végrehajtásra váró feladatok.
	Teendő egyéb fogalmai: Elvégzett -> a feladat elkészült, ekkor lehetőség nyílik a törlés funkióra is a listából.
	Teendők Listája: A feladatok összesége. Mind a végrehajtott, de még nem törölt és az aktív állapotú feladatokat is magába foglaló lista.
	
Szerepkörök: Egységes feladat elosztás, épp aktuális feladat alapján. Megbeszéléseket követően.
			 Adott feladat osztály bontásban való elkészítése.
                         
