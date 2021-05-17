# Rapport

## Om fågelappen 
Fågelappen behandlar de fågelarter som någorlunda regelbundet häckar i Sverige eller under sin flyttning passerar landet.
Fågelappen är till för alla fågelintresserade som snabbt och smidigt vill komma åt information om fåglar, vilken finns lättillänglig i form en lista.

## Process
Ett nytt projekt skapades och lades till på Github.
Två aktiviteter skapades, en för "about page" och en för en sida som senare ska visa information om en fågelart. 

```xml
  <uses-permission android:name="android.permission.INTERNET" />
```
Gav appen internet åtkomst för att komma åt data från webservicen. 

```java
    private ArrayList<Bird> listData;
    private ArrayAdapter<Bird> adapter;
```
Deklarerade två privata medlemsvariabler i MainActivity, en för arraylist och en för arrayadapter. 


```java
  listData = new ArrayList<>();
  adapter = new ArrayAdapter<>(this, R.layout.list_item, listData);
```
Dessa instansieras i oncreate, där arraylist tilldelas ett nytt arraylist objekt och adapter ett adapter objekt.  

````java
    ListView my_listView=(ListView) findViewById(R.id.list_view);
````
En listview deklarerades och initierades med ett befintligt listview objekt med findviewByid. 


HÄR ÄR DU...

En layout fil för list item skapades, där en textview lades till. 
        my_listView.setAdapter(adapter);


## Screenshots på färdig applikation

<img src="Screenshot_1619700249.png" width="400">

**Bild på applikation...**