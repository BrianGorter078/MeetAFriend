package com.meetafriend.meetafriend;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Interests extends FragmentActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {

    private static final String[] SUGGESTIONS = {"Aircraft Spotting", "Airbrushing", "Airsofting", "Acting", "Aeromodeling", "Amateur Astronomy", "Amateur Radio", "Animals/pets/dogs", "Archery", "Arts", "Aquarium", "Astrology", "Astronomy", "Backgammon", "Badminton", "Baseball", "Base Jumping", "Basketball", "Beach/Sun tanning", "Beachcombing", "Beadwork", "Beatboxing", "Becoming A Child Advocate", "Bell Ringing", "Belly Dancing", "Bicycling", "Bicycle Polo", "Bird watching", "Birding", "BMX", "Blacksmithing", "Blogging", "BoardGames", "Boating", "Body Building", "Bonsai Tree", "Bookbinding", "Boomerangs", "Bowling", "Brewing Beer", "Bridge Building", "Bringing Food To The Disabled", "Building A House For Habitat For Humanity", "Building Dollhouses", "Butterfly Watching", "Button Collecting", "Cake Decorating", "Calligraphy", "Camping", "Candle Making", "Canoeing", "Cartooning", "Car Racing", "Casino Gambling", "Cave Diving", "Ceramics", "Cheerleading", "Chess", "Church/church activities", "Cigar Smoking", "Cloud Watching", "Coin Collecting", "Collecting", "Collecting Antiques", "Collecting Artwork", "Collecting Hats", "Collecting Music Albums", "Collecting RPM Records", "Collecting Sports Cards (Baseball, Football, Basketball, Hockey)", "Collecting Swords", "Coloring", "Compose Music", "Computer activities", "Conworlding", "Cooking", "Cosplay", "Crafts", "Crafts (unspecified)", "Crochet", "Crocheting", "Cross-Stitch", "Crossword Puzzles", "Dancing", "Darts", "Diecast Collectibles", "Digital Photography", "Dodgeball", "Dolls", "Dominoes", "Drawing", "Dumpster Diving", "Eating out", "Educational Courses", "Electronics", "Embroidery", "Entertaining", "Exercise (aerobics, weights)", "Falconry", "Fast cars", "Felting", "Fencing", "Fire Poi", "Fishing", "Floorball", "Floral Arrangements", "Fly Tying", "Football", "Four Wheeling", "Freshwater Aquariums", "Frisbee Golf � Frolf", "Games", "Gardening", "Garage Saleing", "Genealogy", "Geocaching", "Ghost Hunting", "Glowsticking", "Gnoming", "Going to movies", "Golf", "Go Kart Racing", "Grip Strength", "Guitar", "Gunsmithing", "Gun Collecting", "Gymnastics", "Gyotaku", "Handwriting Analysis", "Hang gliding", "Herping", "Hiking", "Home Brewing", "Home Repair", "Home Theater", "Horse riding", "Hot air ballooning", "Hula Hooping", "Hunting", "Iceskating", "Illusion", "Impersonations", "Internet", "Inventing", "Jet Engines", "Jewelry Making", "Jigsaw Puzzles", "Juggling", "Keep A Journal", "Jump Roping", "Kayaking", "Kitchen Chemistry", "Kites", "Kite Boarding", "Knitting", "Knotting", "Lasers", "Lawn Darts", "Learn to Play Poker", "Learning A Foreign Language", "Learning An Instrument", "Learning To Pilot A Plane", "Leathercrafting", "Legos", "Letterboxing", "Listening to music", "Locksport", "Lacrosse", "Macram�", "Magic", "Making Model Cars", "Marksmanship", "Martial Arts", "Matchstick Modeling", "Meditation", "Microscopy", "Metal Detecting", "Model Railroading", "Model Rockets", "Modeling Ships", "Models", "Motorcycles", "Mountain Biking", "Mountain Climbing", "Musical Instruments", "Nail Art", "Needlepoint", "Owning An Antique Car", "Origami", "Painting", "Paintball", "Papermaking", "Papermache", "Parachuting", "Paragliding or Power Paragliding", "Parkour", "People Watching", "Photography", "Piano", "Pinochle", "Pipe Smoking", "Planking", "Playing music", "Playing team sports", "Pole Dancing", "Pottery", "Powerboking", "Protesting", "Puppetry", "Pyrotechnics", "Quilting", "Racing Pigeons", "Rafting", "Railfans", "Rapping", "R/C Boats", "R/C Cars", "R/C Helicopters", "R/C Planes", "Reading", "Reading To The Elderly", "Relaxing", "Renaissance Faire", "Renting movies", "Rescuing Abused Or Abandoned Animals", "Robotics", "Rock Balancing", "Rock Collecting", "Rockets", "Rocking AIDS Babies", "Roleplaying", "Running", "Saltwater Aquariums", "Sand Castles", "Scrapbooking", "Scuba Diving", "Self Defense", "Sewing", "Shark Fishing", "Skeet Shooting", "Skiing", "Shopping", "Singing In Choir", "Skateboarding", "Sketching", "Sky Diving", "Slack Lining", "Sleeping", "Slingshots", "Slot Car Racing", "Snorkeling", "Snowboarding", "Soap Making", "Soccer", "Socializing with friends/neighbors", "Speed Cubing (rubix cube)", "Spelunkering", "Spending time with family/kids", "Stamp Collecting", "Storm Chasing", "Storytelling", "String Figures", "Surfing", "Surf Fishing", "Survival", "Swimming", "Tatting", "Taxidermy", "Tea Tasting", "Tennis", "Tesla Coils", "Tetris", "Texting", "Textiles", "Tombstone Rubbing", "Tool Collecting", "Toy Collecting", "Train Collecting", "Train Spotting", "Traveling", "Treasure Hunting", "Trekkie", "Tutoring Children", "TV watching", "Ultimate Frisbee", "Urban Exploration", "Video Games", "Violin", "Volunteer", "Walking", "Warhammer", "Watching sporting events", "Weather Watcher", "Weightlifting", "Windsurfing", "Wine Making", "Wingsuit Flying", "Woodworking", "Working In A Food Pantry", "Working on cars", "World Record Breaking", "Wrestling", "Writing", "Writing Music", "Writing Songs", "Yoga", "YoYo", "Ziplining", "Zumba"};
    private ArrayList<String> memberInterests = new ArrayList<String>();
    private ArrayList<String> searchAnswer = new ArrayList<String>();
    private int i;
    private boolean alreadyChecked = false;
    SearchView sv;
    ListView listview;
    private String searchWord;
    private String firstLetter;
    private String secondWordPart = "";
    private StringBuilder builder;
    private ArrayList<String> otherLetters = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Interests");
        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setVisibility(View.INVISIBLE);
        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setVisibility(View.INVISIBLE);

        ListView listViewAllInterests = (ListView) findViewById(R.id.interestsListView);
        listViewAllInterests.setOnItemClickListener(this);
        ListView listViewSearchAnswer = (ListView) findViewById(R.id.interestsSearchAnswerListView);
        listViewSearchAnswer.setVisibility(View.INVISIBLE);

        sv = (SearchView) findViewById(R.id.interestsSearch);

        setupSearchView();
    }

    private void setupSearchView() {
        sv.setIconifiedByDefault(false);
        sv.setIconified(true);
        sv.setFocusable(false);
        sv.setOnQueryTextListener(this);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("Search interests");
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        System.out.println("You clicked Item: " + id + " at position:" + position + "\nName:" + SUGGESTIONS[position]);
        int amountOfMemberIntrests = memberInterests.size();

        try {
                for(int j = 0; j < amountOfMemberIntrests; j++) {
                    if(amountOfMemberIntrests == 1) {
                        if(memberInterests.get(0).equals(SUGGESTIONS[position])){
                            memberInterests.remove(0);
                            System.out.println(memberInterests.get(0)); // This system.out.prtinln is for some reason needed otherwise the code will crash.
                        }
                    } else if(memberInterests.get(j).equals(SUGGESTIONS[position])) {
                        memberInterests.remove(j);
                        alreadyChecked = true;
                    }
                }

            if (memberInterests.isEmpty()) {
                    memberInterests.add(SUGGESTIONS[position]);
            } else if (memberInterests.size() > 9) {
                System.out.println("You cant add anything anymore");
            } else if (alreadyChecked == false) {
                memberInterests.add(SUGGESTIONS[position]);
                    alreadyChecked = true;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(memberInterests.size());
        alreadyChecked = false;
        System.out.println(memberInterests);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextChange(String searchLetters) {
        builder = new StringBuilder();
        otherLetters.clear();
        searchAnswer.clear();

        if(searchLetters.length() == 1) {
            searchWord = searchLetters.toUpperCase();
            System.out.println(searchWord);
        } else if (searchLetters.length() > 0) {
            for(int i = 1; i < searchLetters.substring(0).length(); i++) {
                otherLetters.add(String.valueOf(searchLetters.charAt(i)).toLowerCase());
            }
            for(String string : otherLetters) {
//                if(builder.length() > 0) {
//                    builder.append("");
//                }
                builder.append(string);
            }


            firstLetter = String.valueOf(searchLetters.charAt(0)).toUpperCase();

            searchWord = firstLetter.concat(builder.toString());
            builder = null;
            System.out.println(otherLetters);
            System.out.println(searchWord);
        }

        for(int k = 0; k < SUGGESTIONS.length; k++) {
            if(SUGGESTIONS[k].startsWith(searchWord) ) {
                searchAnswer.add(SUGGESTIONS[k]);
            }

        }

        if(searchLetters.isEmpty()) {
            searchAnswer.clear();
            System.out.println("true");
                for(int i = 0; i < SUGGESTIONS.length; i++) {
                    searchAnswer.add(SUGGESTIONS[i]);
                }
        }

        makeList();

        System.out.println(searchAnswer);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private void makeList() {
        ListView listViewAllInterests = (ListView) findViewById(R.id.interestsListView);
        ListView listViewSearchAnswer = (ListView) findViewById(R.id.interestsSearchAnswerListView);

        if(searchAnswer.size() < SUGGESTIONS.length) {
            listViewAllInterests.setVisibility(View.INVISIBLE);
            listViewAllInterests.setPadding(0, 8000, 0, 0);

        } else {
            listViewAllInterests.setVisibility(View.VISIBLE);
            listViewAllInterests.setPadding(0, 0, 0, 0);
        }
    }
}