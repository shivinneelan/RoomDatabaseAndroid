# room database Android

#1 - create entity classes like Tables (ex. UserEntity.java) 
     define column names and their column info
#2 - Create App Dao Interfase (AppDao.java)
      mention the querys in there like :
      @Insert
      void insertBasic(UserEntity user);
#3 -  create an Abstract class called AppDatabase and extend RoomDatabase (AppRoomDatabase.java)
#4 -  create Repository interfase and declare functions in there which used to insert, resd, delete etc...
#5 -  CREATE AppRepo class and implement Repository interface and their functions
      create AppRepo constructor with Application Argument
       initialise AppRoomDatabase and AppDao 
       craete AsyncTask class to perform the query operations

  
