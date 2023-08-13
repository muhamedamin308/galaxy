package com.example.recycleview.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.recycleview.R;

@Database(entities = Planet.class, version = 1)
public abstract class GalaxyRoomDB extends RoomDatabase {
    private static GalaxyRoomDB instance;
    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new GalaxySpaceAsyncTask(instance).execute();
        }
    };

    //Singleton
    public static synchronized GalaxyRoomDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), GalaxyRoomDB.class, "planet-data").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;
    }

    public abstract GalaxyDao galaxyDao();

    private static class GalaxySpaceAsyncTask extends AsyncTask<Void, Void, Void> {
        private final GalaxyDao mgalaxyDao;

        GalaxySpaceAsyncTask(GalaxyRoomDB galaxyRoomdb) {
            mgalaxyDao = galaxyRoomdb.galaxyDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mgalaxyDao.insert(new Planet(R.drawable.mercury2,
                    "Mercury",
                    "The smallest planet in our solar system and nearest to the Sun",
                    "Mercury is only slightly larger than Earth's Moon. \n" + "From the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth," + " and the sunlight would be as much as seven times brighter." + " Despite its proximity to the Sun, Mercury is not the hottest planet in our solar system – that title belongs to nearby Venus," + " thanks to its dense atmosphere. Because of Mercury's elliptical – egg-shaped – orbit, and sluggish rotation," + " the Sun appears to rise briefly, set, and rise again from some parts of the planet's surface." + " The same thing happens in reverse at sunset.",
                    2440,
                    "Terrestrial",
                    88));

            mgalaxyDao.insert(new Planet(R.drawable.venus2,
                    "Venus",
                    "Venus is the second planet from the Sun and is Earth’s closest planetary neighbor.",
                    "Similar in structure and size to Earth, Venus's thick atmosphere traps heat in a runaway greenhouse effect, making it the hottest planet in our solar system." + "Venus has a thick, toxic atmosphere filled with carbon dioxide and it’s perpetually shrouded in thick," + " yellowish clouds of sulfuric acid that trap heat, causing a runaway greenhouse effect." + " It’s the hottest planet in our solar system, even though Mercury is closer to the Sun." + " Surface temperatures on Venus are about 900 degrees Fahrenheit (475 degrees Celsius) – hot enough to melt lead." + " The surface is a rusty color and it’s peppered with intensely crunched mountains and thousands of large volcanoes." + " Scientists think it’s possible some volcanoes are still active.",
                    6052,
                    "Terrestrial",
                    225));

            mgalaxyDao.insert(new Planet(R.drawable.earth2,
                    "Earth",
                    "Our home planet is the third planet from the Sun, and the only place we know of so far that’s inhabited by living things.",
                    "While Earth is only the fifth largest planet in the solar system, it is the only world in our solar system with liquid water on the surface." + " Just slightly larger than nearby Venus, Earth is the biggest of the four planets closest to the Sun," + " all of which are made of rock and metal.\n" + "Earth is the only planet in the Solar System whose English name does not come from Greek or Roman mythology." + " The name was taken from Old English and Germanic. It simply means \"the ground.\" There are," + " of course, many names for our planet in the thousands of languages spoken by the people of the third planet from the Sun.",
                    6371,
                    "Terrestrial",
                    365));

            mgalaxyDao.insert(new Planet(R.drawable.mars2,
                    "Mars",
                    "Mars is the fourth planet from the Sun – a dusty, cold, desert world with a very thin atmosphere.",
                    "Mars is also a dynamic planet with seasons, polar ice caps, canyons, extinct volcanoes," + " and evidence that it was even more active in the past.\n" + "Mars is a dusty, cold, desert world with a very thin atmosphere." + " There is strong evidence Mars was – billions of years ago – wetter and warmer, with a thicker atmosphere.",
                    3390,
                    "Terrestrial",
                    687));

            mgalaxyDao.insert(new Planet(R.drawable.jupiter2,
                    "Jupiter",
                    "Jupiter has a long history of surprising scientists – all the way back to 1610 when Galileo Galilei found the first moons beyond Earth.",
                    "Fifth in line from the Sun, Jupiter is, by far, " + "the largest planet in the solar system – more than twice as massive as all the other planets combined.\n" + "Jupiter's familiar stripes and swirls are actually cold," + " windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium." + " Jupiter’s iconic Great Red Spot is a giant storm bigger than Earth that has raged for hundreds of years." + "Jupiter is more than twice as massive than the other planets of our solar system combined." + " The giant planet's Great Red Spot is a centuries-old storm bigger than Earth.",
                    69911,
                    "Gas Giant",
                    4333));

            mgalaxyDao.insert(new Planet(R.drawable.saturn2,
                    "Saturn",
                    "Saturn is the sixth planet from the Sun and the second-largest planet in our solar system.",
                    "Adorned with thousands of beautiful ringlets, Saturn is unique among the planets." + " It is not the only planet to have rings – made of chunks of ice and rock –" + " but none are as spectacular or as complicated as Saturn's.\n" + "Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium." + "Adorned with a dazzling, complex system of icy rings, Saturn is unique in our solar system." + " The other giant planets have rings, but none are as spectacular as Saturn's.\n",
                    58232,
                    "Gas Giant",
                    10759));

            mgalaxyDao.insert(new Planet(R.drawable.uranus2,
                    "Uranus",
                    "Uranus is the seventh planet from the Sun, and has the third-largest diameter in our solar system.",
                    "Uranus—seventh planet from the Sun—rotates at a nearly 90-degree angle from the plane of its orbit." + " This unique tilt makes Uranus appear to spin on its side.\n" + "It was the first planet found with the aid of a telescope," + " Uranus was discovered in 1781 by astronomer William Herschel, " + "although he originally thought it was either a comet or a star. It was two years later that the object was universally accepted as a new planet," + " in part because of observations by astronomer \"Johann Elert Bode\"." + " Herschel tried unsuccessfully to name his discovery Georgium Sidus after King George III." + " Instead, the scientific community accepted Bode's suggestion to name it Uranus," + " the Greek god of the sky, as suggested by Bode.",
                    25362,
                    "Ice Giant",
                    30687));

            mgalaxyDao.insert(new Planet(R.drawable.neptune2,
                    "Neptune",
                    "Dark, cold, and whipped by supersonic winds, ice giant Neptune is the eighth and most distant planet in our solar system.",
                    "More than 30 times as far from the Sun as Earth," + " Neptune is the only planet in our solar system not visible to the naked eye and the first predicted by" + " mathematics before its discovery. In 2011 Neptune completed its first 165-year orbit since its discovery in 1846.\n" + "NASA's Voyager 2 is the only spacecraft to have visited Neptune up close." + " It flew past in 1989 on its way out of the solar system. " + "Neptune—the eighth and most distant major planet orbiting our Sun—is dark," + " cold and whipped by supersonic winds. It was the first planet located through mathematical calculations.",
                    24622,
                    "Ice Giant",
                    60190));
            return null;
        }
    }
}