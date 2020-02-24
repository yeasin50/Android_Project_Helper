//Oncreate 


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

 if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,
                    new BatchFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_addingstd);
        }

//end of onCreate

@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_Attendance:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,
                        new AttendanceFragment()).commit();
                break;

            case R.id.nav_STDdetails:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_Container,
                        new StudentsDetailsFragment()).commit();
                break;

            case R.id.nav_addingstd:
                ShowSTDAdding_Dialog();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
 @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }


