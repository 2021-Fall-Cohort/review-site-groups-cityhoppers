package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.model.CityReview;
import org.wecancodeit.reviews.model.HashPage;
import org.wecancodeit.reviews.model.Region;
import org.wecancodeit.reviews.repos.CityRepo;
import org.wecancodeit.reviews.repos.HashRepo;
import org.wecancodeit.reviews.repos.RegionsRepo;

@Component
public class Populator implements CommandLineRunner {

    private CityRepo cityRepo;
    private HashRepo hashRepo;
    private RegionsRepo regionRepo;

    public Populator(CityRepo cityRepo, HashRepo hashRepo, RegionsRepo regionRepo) {
        this.cityRepo = cityRepo;
        this.hashRepo = hashRepo;
        this.regionRepo = regionRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Region midwest = new Region("Midwest", "The Heartland of America", "/img/midwest.jpg");
        regionRepo.save(midwest);

        Region west = new Region("West", "The New Frontier!", "/img/West.jpg");
        regionRepo.save(west);

        Region east = new Region("NorthEast", "Birthplace of America", "/img/NewEngland.jpg");
        regionRepo.save(east);

        Region south = new Region("The South", "Bless Your Heart!", "/img/South.jpg");
        regionRepo.save(south);

        HashPage nightLife = new HashPage("Night Life", "Party 'til the sun comes up in America's hottest nightlife hubs!", "/img/nightlife.jpg");
        hashRepo.save(nightLife);

        HashPage musicCulture = new HashPage("Music Culture", "Explore the musical roots of America!", "/img/music.jpg");
        hashRepo.save(musicCulture);

        HashPage historicAttractions = new HashPage("Historic Attractions", "Explore the rich culture of America's most storied cities!", "/img/history.jpg");
        hashRepo.save(historicAttractions);

        HashPage foodCulture = new HashPage("Food Culture", "Enjoy the finest cuisine America has to offer!", "/img/restaurant.jpg");
        hashRepo.save(foodCulture);

        CityReview cityReview1 = new CityReview("Portland, OR", "City of Roses", 645291l, "Portland, Oregon’s largest city, sits on the Columbia and Willamette rivers, in the shadow of snow-capped Mount Hood. It’s known for its parks, bridges and bicycle paths, as well as for its eco-friendliness and its microbreweries and coffeehouses. Iconic Washington Park encompasses sites from the formal Japanese Garden to Oregon Zoo and its railway. The city hosts thriving art, theater and music scenes.", "/img/portland1.jpeg", west, foodCulture, musicCulture);
        CityReview cityReview2 = new CityReview("Seattle, WA", "Emerald City", 7370000l, "Seattle, a city on Puget Sound in the Pacific Northwest, is surrounded by water, mountains and evergreen forests, and contains thousands of acres of parkland. Washington State’s largest city, it’s home to a large tech industry, with Microsoft and Amazon headquartered in its metropolitan area. The futuristic Space Needle, a 1962 World’s Fair legacy, is its most iconic landmark", "/img/seattle.jpg", west, historicAttractions, musicCulture);
        CityReview cityReview3 = new CityReview("Columbus, OH", "Buckeye City", 878553l, "Columbus is Ohio’s state capital. The city’s Scioto Mile is a string of parks on both sides of the Scioto River, with a huge interactive fountain and trails. On the west bank, the COSI science center offers hands-on exhibits and a planetarium. Downtown, the Columbus Museum of Art includes American and European paintings and a sculpture garden. The German Village area has restored brick houses built by 1800s settlers", "/img/Columbus.jpg", midwest, foodCulture);
        CityReview cityReview4 = new CityReview("Washington D.C.", "Capital City", 500000l, "Washington, DC, the U.S. capital, is a compact city on the Potomac River, bordering the states of Maryland and Virginia. It’s defined by imposing neoclassical monuments and buildings – including the iconic ones that house the federal government’s 3 branches: the Capitol, White House and Supreme Court. It's also home to iconic museums and performing-arts venues such as the Kennedy Center.", "/img/WashingtonD_C.jpg", east, historicAttractions, musicCulture);
        CityReview cityReview5 = new CityReview("Los Angeles, CA", "City of Angels", 3900000l, "Los Angeles is a sprawling Southern California city and the center of the nation’s film and television industry. Near its iconic Hollywood sign, studios such as Paramount Pictures, Universal and Warner Brothers offer behind-the-scenes tours. On Hollywood Boulevard, TCL Chinese Theatre displays celebrities’ hand- and footprints, the Walk of Fame honors thousands of luminaries and vendors sell maps to stars’ homes.", "/img/LosAngeles.jpg", west, nightLife, musicCulture, foodCulture);
        CityReview cityReview6 = new CityReview("Salt Lake City, UT", "The Crossroads of the West", 201249l, "Salt Lake City is the capital and most populous city of the U.S. state of Utah, as well as the seat of Salt Lake County, the most populous county in Utah. With an estimated population of 199,723 in 2020, the city is the core of the Salt Lake City metropolitan area, which has a population of 1,257,936.", "/img/SLC.jpg",west, nightLife, foodCulture, historicAttractions);
        CityReview cityReview7 = new CityReview("Atlanta, GA", "The Big Peach", 488800l, "Atlanta is the capital of the U.S. state of Georgia. It played an important part in both the Civil War and the 1960s Civil Rights Movement. Atlanta History Center chronicles the city's past, and the Martin Luther King Jr. National Historic Site is dedicated to the African-American leader’s life and times. Downtown, Centennial Olympic Park, built for the 1996 Olympics, encompasses the massive Georgia Aquarium.", "/img/ATL.jpg", south, musicCulture, foodCulture, nightLife, historicAttractions);
        CityReview cityReview8 = new CityReview("Nashville, TN", "Music City", 692587l, "Nashville is the capital of the U.S. state of Tennessee and home to Vanderbilt University. Legendary country music venues include the Grand Ole Opry House, home of the famous “Grand Ole Opry” stage and radio show. The Country Music Hall of Fame and Museum and historic Ryman Auditorium are Downtown, as is the District, featuring honky-tonks with live music and the Johnny Cash Museum, celebrating the singer's life.", "/img/Nashville.jpg",south, musicCulture, historicAttractions, nightLife);
        CityReview cityReview9 = new CityReview("New Orleans, LA", "The Big Easy", 390845l, "New Orleans is a Louisiana city on the Mississippi River, near the Gulf of Mexico. Nicknamed the \"Big Easy,\" it's known for its round-the-clock nightlife, vibrant live-music scene and spicy, singular cuisine reflecting its history as a melting pot of French, African and American cultures. Embodying its festive spirit is Mardi Gras, the late-winter carnival famed for raucous costumed parades and street parties.", "/img/NOLA.jpg", south, musicCulture, foodCulture, historicAttractions, nightLife);
        CityReview cityReview10 = new CityReview("Savannah, GA", "Hostess City of the South", 145403l, "Savannah, a coastal Georgia city, is separated from South Carolina by the Savannah River. It’s known for manicured parks, horse-drawn carriages and antebellum architecture. Its historic district is filled with cobblestoned squares and parks such as Forsyth Park shaded by oak trees covered with Spanish moss. At the center of this picturesque district is the landmark, Gothic-Revival Cathedral of Saint John the Baptist.", "/img/savannah.jpg", south, historicAttractions, musicCulture);
        CityReview cityReview11 = new CityReview("Miami, FL", "The Magic City", 442241l, "Miami, officially the City of Miami, is a coastal metropolis located in Miami-Dade County in southeastern Florida, United States. With a population of 442,241 as of the 2020 census, it is the 44th-largest city in the United States and the core of the nation's eighth-largest metropolitan area.", "/img/miami.jpg", south, musicCulture, nightLife);
        CityReview cityReview12 = new CityReview("Mobile, AL", "The Azalea City", 190432l, "Mobile is a port city on Alabama’s Gulf Coast. The WWII-era USS Alabama battleship is anchored in Battleship Memorial Park. Floats, costumes and photos at the Mobile Carnival Museum illuminate the city’s centuries-old Mardi Gras tradition. The 1850 Cathedral Basilica of the Immaculate Conception features intricate German stained glass. International fine and decorative art is displayed at the Mobile Museum of Art.", "/img/Mobile.jpg", south, historicAttractions, foodCulture);
        CityReview cityReview13 = new CityReview("Boston, MA", "Beantown", 684379l, "Boston, officially the City of Boston, is the capital and most populous city of the Commonwealth of Massachusetts in the United States and 24th-most populous city in the country. The city proper covers 48.4 square miles with a population of 675,647 in 2020, also making it the most populous city in New England. ", "/img/Boston.jpg", east, historicAttractions, musicCulture, nightLife);
        CityReview cityReview14 = new CityReview("Charleston, WV", "Charlie West", 48006l, "Charleston, at the confluence of the Elk and Kanawha rivers, is West Virginia’s capital city. A riverside complex includes the gold-domed State Capitol, the Governor’s Mansion and the West Virginia State Museum and theater. The Clay Center for the Arts and Sciences has art and discovery museums, a planetarium and a concert hall. Downtown’s Capitol Market houses food vendors and eateries in a former freight station.", "/img/Charleston.jpg", east, historicAttractions, foodCulture);
        CityReview cityReview15 = new CityReview("New York, NY", "The City that Never Sleeps", 8419000l, "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square", "/img/NYC.jpg", east, historicAttractions, foodCulture, nightLife, musicCulture);
        CityReview cityReview16 = new CityReview("Burlington, VT", "The Queen City", 42545l, "Burlington, also known as Burlington Coat Factory, is an American national off-price department store retailer, and a division of Burlington Coat Factory Warehouse Corporation with 740 stores in 40 states and Puerto Rico, with its corporate headquarters located in Burlington Township, New Jersey.","/img/Burlington.jpg", east, foodCulture, musicCulture);
        CityReview cityReview17 = new CityReview("Philadelphia, PA", "City of Brotherly Love", 1579000l, "Philadelphia, Pennsylvania’s largest city, is notable for its rich history, on display at the Liberty Bell, Independence Hall (where the Declaration of Independence and Constitution were signed) and other American Revolutionary sites. Also iconic are the steps of the Philadelphia Museum of Art, immortalized by Sylvester Stallone’s triumphant run in the film \"Rocky.\"", "/img/philly.png", east, musicCulture, historicAttractions, nightLife);
        CityReview cityReview18 = new CityReview("Klamath Falls, OR", "The Dirty K", 21335l, "Klamath Falls is a city in and the county seat of Klamath County, Oregon, United States. The city was originally called Linkville when George Nurse founded the town in 1867. It was named after the Link River, on whose falls the city was sited. The name was changed to Klamath Falls in 1893.", "/img/KFalls.jpg", west, historicAttractions);
        CityReview cityReview19 = new CityReview("Hood River, OR", "City in the Shadow of the Mountain", 7715l, "The city of Hood River is the seat of Hood River County, Oregon, United States. It is a port on the Columbia River, and is named for the nearby Hood River. As of the 2010 census, the city population was 7,167.", "/img/HoodRiver.jpg", west, foodCulture, musicCulture);
        CityReview cityReview20 = new CityReview("Chicago, IL", "The Windy City", 2710000l, "Chicago, on Lake Michigan in Illinois, is among the largest cities in the U.S. Famed for its bold architecture, it has a skyline punctuated by skyscrapers such as the iconic John Hancock Center, 1,451-ft. Willis Tower (formerly the Sears Tower) and the neo-Gothic Tribune Tower. The city is also renowned for its museums, including the Art Institute of Chicago with its noted Impressionist and Post-Impressionist works.", "/img/CHI.jpg", midwest, historicAttractions, musicCulture, foodCulture, nightLife);
        CityReview cityReview21 = new CityReview("Cleveland, OH", "The Forest City", 385282l, "Cleveland, officially the City of Cleveland, is a major city in the U.S. state of Ohio, and the county seat of Cuyahoga County. It is located along the southern shore of Lake Erie, across the U.S. maritime border with Canada and approximately 60 miles west of the Ohio-Pennsylvania state border.", "/img/CLE.jpg", midwest, foodCulture, historicAttractions);
        CityReview cityReview22 = new CityReview("Detroit, MI", "Motor City", 674841l, "Detroit is the largest city in the midwestern state of Michigan. Near Downtown, the neoclassical Detroit Institute of Arts is famed for the Detroit Industry Murals painted by Diego Rivera, and inspired by the city’s ties to the auto industry, giving it the nickname \"Motor City.\" Detroit is also the birthplace of Motown Records, whose chart-topping history is on display at their original headquarters, Hitsville U.S.A.", "/img/Detroit.jpg", midwest, musicCulture, historicAttractions, nightLife);
        CityReview cityReview23 = new CityReview("Milwaukee, WI", "Cream City", 594598l, "Milwaukee is a city in the U.S. state of Wisconsin on Lake Michigan's western shore. It's known for its breweries, many of which offer tours chronicling its role in the beer industry. Overlooking the Menomonee River, the Harley-Davidson Museum displays classic motorcycles, including one of Elvis Presley’s. Nearby is the Milwaukee Public Museum, with its large-scale European Village and a recreation of old Milwaukee.", "/img/milwaukee.jpg", midwest, foodCulture, historicAttractions);
        CityReview cityReview24 = new CityReview("St. Louis, MO", "The Gateway to the West", 308174l, "St. Louis is a major city in Missouri along the Mississippi River. Its iconic, 630-ft. Gateway Arch, built in the 1960s, honors the early 19th-century explorations of Lewis and Clark and America's westward expansion in general. Replica paddlewheelers ply the river, offering views of the arch. The Soulard district is home to barbecue restaurants and clubs playing blues music.", "/img/STLouis.jpg", midwest, historicAttractions);
        cityRepo.save(cityReview1);
        cityRepo.save(cityReview2);
        cityRepo.save(cityReview3);
        cityRepo.save(cityReview4);
        cityRepo.save(cityReview5);
        cityRepo.save(cityReview6);
        cityRepo.save(cityReview7);
        cityRepo.save(cityReview8);
        cityRepo.save(cityReview9);
        cityRepo.save(cityReview10);
        cityRepo.save(cityReview11);
        cityRepo.save(cityReview12);
        cityRepo.save(cityReview13);
        cityRepo.save(cityReview14);
        cityRepo.save(cityReview15);
        cityRepo.save(cityReview16);
        cityRepo.save(cityReview17);
        cityRepo.save(cityReview18);
        cityRepo.save(cityReview19);
        cityRepo.save(cityReview20);
        cityRepo.save(cityReview21);
        cityRepo.save(cityReview22);
        cityRepo.save(cityReview23);
        cityRepo.save(cityReview24);
    }
}
