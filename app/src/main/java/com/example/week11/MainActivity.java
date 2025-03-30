package com.example.week11;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week11.adapter.RepositoryAdapter;
import com.example.week11.container.DataProvider;
import com.example.week11.container.MatchIterator;
import com.example.week11.container.MatchRepository;
import com.example.week11.container.PlayerIterator;
import com.example.week11.container.PlayerRepository;
import com.example.week11.container.Repository;
import com.example.week11.container.TeamIterator;
import com.example.week11.container.TeamRepository;
import com.example.week11.model.Match;
import com.example.week11.model.Player;
import com.example.week11.model.SoccerEntity;
import com.example.week11.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private TextView tvEmptyView;
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private DataProvider dataProvider = new DataProvider();
    private List<SoccerEntity> entities = new ArrayList<>();
    private Repository<SoccerEntity> rep;
    private RepositoryAdapter adapter;
    enum Filter {
        ALL,
        PLAYER,
        TEAM,
        MATCH
    }
    Filter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initViews();
        setupRepository();
        setupRecyclerView();
        setupButtonListeners();
        filter = Filter.ALL;

    }

    private void initViews() {
        recycler = findViewById(R.id.recycler_manager);
        tvEmptyView = findViewById(R.id.tv_empty_view);
    }

    private void setupRepository() {
        rep = new Repository<>();
        matchRepository = new MatchRepository();
        playerRepository = new PlayerRepository();
        teamRepository = new TeamRepository();

        List<Match> matches = dataProvider.createSampleMatch();
        for(Match m : matches){
            rep.add(m);
            matchRepository.add(m);
        }

        List<Player> players = dataProvider.createSamplePlayers();
        for(Player p : players){
            rep.add(p);
            playerRepository.add(p);
        }

        List<Team> teams = dataProvider.createSampleTeams();
        for(Team t : teams){
            rep.add(t);
            teamRepository.add(t);
        }

    }

    private void setupRecyclerView() {
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RepositoryAdapter(
                this,
                new ArrayList<>(),
                (entity, position) -> {
                    // Lambda function for item click
                    showItemDetails(entity);
                }
        );
        recycler.setAdapter(adapter);
        updateAdapterItems(rep.getAll());

    }

    private void updateAdapterItems(List<SoccerEntity> entities) {
        adapter.updateItems(entities);
        recycler.post(() -> adapter.notifyDataSetChanged());


        // Show/hide empty view
        if (entities.isEmpty()) {
            tvEmptyView.setVisibility(android.view.View.VISIBLE);
            recycler.setVisibility(android.view.View.GONE);
        } else {
            tvEmptyView.setVisibility(android.view.View.GONE);
            recycler.setVisibility(android.view.View.VISIBLE);
        }
    }

    private  void setupButtonListeners() {
        EditText etFilter = findViewById(R.id.editTextText);
        Button btnShowAll = findViewById(R.id.btn_show_all);

        btnShowAll.setOnClickListener(v -> {
            etFilter.setVisibility(View.GONE);
            // Lambda function for click handler
            updateAdapterItems(rep.getAll());
            showToast("Showing all items");
            filter = Filter.ALL;
        });

        Button btnFilterMatch = findViewById(R.id.btn_filter_match);
        btnFilterMatch.setOnClickListener( v -> {
            etFilter.setVisibility(View.VISIBLE);
            etFilter.setHint("Enter the league:");
            filter = Filter.MATCH;

            updateAdapterItems(rep.filter(item -> item instanceof Match));
            showToast("Filtered: Match only");
        });

        Button btnFilterPlayer = findViewById(R.id.btn_filter_player);
        btnFilterPlayer.setOnClickListener( v -> {
            etFilter.setVisibility(View.VISIBLE);
            etFilter.setHint("Enter the team:");
            filter = Filter.PLAYER;

            updateAdapterItems(rep.filter(item -> item instanceof Player));
            showToast("Filtered: Player only");
        });

        Button btnFilterTeam = findViewById(R.id.btn_filter_team);
        btnFilterTeam.setOnClickListener(v -> {
            etFilter.setVisibility(View.VISIBLE);
            etFilter.setHint("Enter the team:");

            filter = Filter.TEAM;
            // Lambda predicate example
            updateAdapterItems(
                    rep.filter(item -> item instanceof Team)
            );
            showToast("Filtered: Team only");
        });

        Button btnCustomIterator = findViewById(R.id.btn_custom_iterator);
        btnCustomIterator.setOnClickListener(v -> {
            demonstrateCustomIterator();
        });

        etFilter.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                showToast("Edited");
                String teamName = editable.toString().trim().toLowerCase();
                switch (filter){
                    case MATCH:
                        updateAdapterItems(new ArrayList<SoccerEntity>(matchRepository.filterByTeam(teamName)));
                        break;
                    case PLAYER:
                        updateAdapterItems(new ArrayList<SoccerEntity>(playerRepository.filterByTeam(teamName)));
                        break;
                    case TEAM:
                        updateAdapterItems(new ArrayList<SoccerEntity>(teamRepository.filterByLeague(teamName)));
                }
            }
        });
    }

    private void demonstrateCustomIterator() {
        StringBuilder result = new StringBuilder("Using custom iterator:\nPlayers:\n");

        // Get custom iterator
        PlayerIterator iteratorP = playerRepository.getPlayerIterator();

        // Manually use the iterator
        while (iteratorP.hasNext()) {
            Player item = iteratorP.next();
            result.append("\t").append(item.getName()).append("\n");
        }
        result.append("Teams:\n");
        TeamIterator iteratorT = teamRepository.getTeamIterator();
        while (iteratorT.hasNext()) {
            Team item = iteratorT.next();
            result.append("\t").append(item.getName()).append("\n");
        }
        result.append("Matches:\n");
        MatchIterator iteratorM = matchRepository.getMatchIterator();
        while (iteratorM.hasNext()) {
            Match item = iteratorM.next();
            result.append("\t").append(item.getHomeTeam()).append(" vs ").append(item.getAwayTeam()).append("\n");
        }

        showToast("Check logs for custom iterator demo results");
        System.out.println(result.toString());
    }

    private void showItemDetails(SoccerEntity entity) {
        // Simple toast to show item details
        showToast("Selected: " + entity.getName());
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}