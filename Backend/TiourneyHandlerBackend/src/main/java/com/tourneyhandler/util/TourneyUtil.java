package com.tourneyhandler.util;

import java.util.List;

import com.tourneyhandler.entities.Player;

public class TourneyUtil{

	public Player PlayMatch(Player a, Player b)
	{
		return b;
	}
	
	public void Sort(List<Player> ls)
	{
		int n = ls.size();
		for (int gap = n/2; gap > 0; gap /=2)
		{
			for(int i = gap; i < n; i++)
			{
				Player temp = ls.get(i);
				
				for(int j = i; j >= gap && ls.get(j-gap).getPrestige() > temp.getPrestige(); j-= gap)
				{
					ls.set(j, ls.get(j-gap));
					ls.set(j, temp);
				}
			}
				
		}
	}
}