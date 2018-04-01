package com.lark.woodturning;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeViewHolder> {

    private static final String[] INSTRUCTIONS = {
            "Turn a cylinder to diameter 'D’\nD = %s",
            "Mark two lines at distance 'D' and two lines at distance 'A' in from both lines above\nTurn two spigots to diameter 'B'\nA = %.2f, B = %.2f, D = %.2f",
            "Turn straight surface between lines to form octagon",
            "Mark lines in RED distance 'E' on either side of black lines and turn two spigots to diameter 'C' on both ends\nC = %.2f, E = %.2f",
            "Turn straight surfaces between RED lines to form 16 equal facets",
            "By eye, divide each facet in half and make a series of curved cuts between these lines to form sphere",
            "Part off and re-chuck to remove final spigot"
    };

    private final List<Pair<String, Integer>> data = Arrays.asList(
            new Pair<>(INSTRUCTIONS[0], R.drawable.slide1),
            new Pair<>(INSTRUCTIONS[1], R.drawable.slide2),
            new Pair<>(INSTRUCTIONS[2], R.drawable.slide3),
            new Pair<>(INSTRUCTIONS[3], R.drawable.slide4),
            new Pair<>(INSTRUCTIONS[4], R.drawable.slide5),
            new Pair<>(INSTRUCTIONS[5], R.drawable.slide6),
            new Pair<>(INSTRUCTIONS[6], R.drawable.slide7)
    );

    public void setDerivedValues(double diameter, double a, double b, double c, double e) {
        data.set(0, new Pair<>(String.format(INSTRUCTIONS[0], diameter), data.get(0).second));
        data.set(1, new Pair<>(String.format(INSTRUCTIONS[1], a, b, diameter), data.get(1).second));
        data.set(3, new Pair<>(String.format(INSTRUCTIONS[3], c, e), data.get(3).second));
    }

    @NonNull @Override
    public SwipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SwipeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SwipeViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
