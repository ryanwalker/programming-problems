package com.ryanwalker.problems.minesweeper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Tile {

  private boolean flagged;
  private boolean mine;
  private boolean visible;

}
