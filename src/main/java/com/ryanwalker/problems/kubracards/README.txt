# House of Cards
Implement a library representing a deck of playing cards.  

A regular deck of cards consists of four suits (hearts, clubs, diamonds, spades)

and 13 cards in each suit (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King) for a total of 52 cards (ignore the jokers).

The following can be done with a deck of cards:

Shuffle:  Randomizes the order of the cards.

Cut:  Splits the deck at a point chosen by the player;
cards above the split point are placed on the bottom of the deck (without reordering).
The first card below the split becomes the top of the deck.
The first card above the split becomes the bottom of the deck.

Deal:  Retrieves the top card and removes it from the deck.

Turn Over:  Retrieves the top card but does not remove it from the deck.

Search:  Finds the position of a given card in the deck
(top of the deck is the first card, next card is the second, etc.).

New Order:  Places the remaining cards in the deck in the order of a new deck of cards
(top to bottom:  hearts A-K, clubs A-K, diamonds K-A, spades K-A).


A pinochle deck may be formed by combining two normal decks of cards and removing cards 2-8, for a total of 48 cards.  

In addition, pinochle uses unconventional card ordering, namely (from lowest to highest):  9, Jack, Queen, King, 10, Ace.  
Add support to the library for a pinochle deck.

Implement a driver to partially test and demonstrate usage of the library (e.g., create a deck of cards, shuffle the cards, deal the cards, etc.).  The driver may be hard coded or user-interaction driven, may use unit testing techniques, etc.  Looking for a sample only; comprehensive testing is not required.