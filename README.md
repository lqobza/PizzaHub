# PizzaHub

  * Egy pizzázó webes felületét szeretnénk megalkotni.
  
## Funkcionális követelmények
  * Bejelentkezés/Kijelentkezés személyes adatokkal
  * Pizzarendelés (esetleg mást is)
  * Kosár fünkció (több pizzát egyszerre)
  
## Nem funkcionális követelmények
  * User adatbázis
  * Feltét + alap adatbázis
  * A fentebbi kettőből összerakott lista az előre összerakott pizzákkal
  * Akciós pizzák
  * A kosár adatai ne vesszenek el kijelentkezésig
  * Esetleg kuponok felvitele
  
## Backend doksi
### Authorizáció
  * 2 féle jog van admin és felhasználó
  * A bejelentkezés a böngészőből kilépésig megmarad
  
### Entitások
  * Mindegyik entitásnak van delete/post/get metódusa
  * A delete/post műveletekhez admin jog kell
  * A post methódus map-et vár nem objektumot (Kaptunk érte pontlevonást, bár nem értem miért, hiszen működik. Lehetséges/valószínű, hogy változni fog, ha kész  a frontend.)
  
#### A felhasználók adatai elérhetőek a /felhasznalok alatt
  * /users : felhasználók listája
  * /users/id : az id azonosítójú felhasználó adatai
  * /users/id/pizzak : az id azonosítójú felhasználo által rendelt pizzák
  
#### A pizzák adatai elérhetőek a /pizzak alatt
  * /pizzak : a pizzák listája
  * /pizzak/id : az id azonosítójú pizza adatai
  * /pizzak/id/feltetek : az id azonosítójú pizza feltétei
  * /pizzak/id/alap : az id azonosítójú pizza alapja
  * /pizzak/id/teszta : az id azonosítójú pizza tesztája
  * /pizzak/id/users : az id azonosítójú pizzát megrendelő felhasználók listája
  
#### A feltétek adatai elérhetőek a /feltetek alatt
  * /feltetek : a feltétek listája
  * /feltetek/id : az id azonosítójú feltét adatai
  * /feltetek/id/pizzak : az id azonosítójú feltéttel rendelkező pizzák listája
  
#### A tészták adatai elérhetőek a /tesztak alatt
  * /tesztak : a tészták listája
  * /tesztak/id : az id azonosítójú tészta
  * /tesztak/id/pizzak : az id azonosítójú tésztával rendelkező pizzák listája

#### Az alapok adatai elérhetőek a /alapok alatt
  * /alapok : a tészták listája
  * /alapok/id : az id azonosítójú tészta
  * /alapok/id/pizzak : az id azonosítójú alappal rendelkező pizzák listája

