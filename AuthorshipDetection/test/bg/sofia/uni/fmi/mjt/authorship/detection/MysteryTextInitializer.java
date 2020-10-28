package bg.sofia.uni.fmi.mjt.authorship.detection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MysteryTextInitializer {

	private static String mysteryText1 = "THE RAVEN\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"THERE was once a Queen and she had a little daughter, who was as yet a\r\n" + 
			"babe in arms; and once the child was so restless that the mother could\r\n" + 
			"get no peace, do what she would; so she lost patience, and seeing a\r\n" + 
			"flight of ravens passing over the castle, she opened the window and said\r\n" + 
			"to her child,\r\n" + 
			"\r\n" + 
			"\"Oh, that thou wert a raven and couldst fly away, that I might be at\r\n" + 
			"peace.\"\r\n" + 
			"\r\n" + 
			"No sooner had she uttered the words, than the child was indeed changed\r\n" + 
			"into a raven, and fluttered from her arms out of the window. And she\r\n" + 
			"flew into a dark wood and stayed there a long time, and her parents knew\r\n" + 
			"nothing of her. Once a man was passing through the wood, and he heard\r\n" + 
			"the raven cry, and he followed the voice; and when he came near it said,\r\n" + 
			"\r\n" + 
			"\"I was born a King's daughter, and have been bewitched, but thou canst\r\n" + 
			"set me free.\"\r\n" + 
			"\r\n" + 
			"\"What shall I do?\" asked the man.\r\n" + 
			"\r\n" + 
			"\"Go deeper into the wood,\" said she, \"and thou shalt find a house and an\r\n" + 
			"old woman sitting in it: she will offer thee meat and drink, but thou\r\n" + 
			"must take none; if thou eatest or drinkest thou fallest into a deep\r\n" + 
			"sleep, and canst not set me free at all. In the garden behind the house\r\n" + 
			"is a big heap of tan, stand upon that and wait for me. Three days, at\r\n" + 
			"about the middle of the day, shall I come to thee in a car drawn by four\r\n" + 
			"white horses the first time, by four red ones the second time, and\r\n" + 
			"lastly by four black ones; and if thou art not waking but sleeping, thou\r\n" + 
			"failest to set me free.\"\r\n" + 
			"\r\n" + 
			"The man promised to do all she said.\r\n" + 
			"\r\n" + 
			"\"But ah!\" cried she, \"I know quite well I shall not be set free of thee;\r\n" + 
			"something thou wilt surely take from the old woman.\"\r\n" + 
			"\r\n" + 
			"But the man promised yet once more that certainly he would not touch the\r\n" + 
			"meat or the drink. But when he came to the house the old woman came up\r\n" + 
			"to him.\r\n" + 
			"\r\n" + 
			"\"My poor man,\" said she to him, \"you are quite tired out, come and be\r\n" + 
			"refreshed, and eat and drink.\"\r\n" + 
			"\r\n" + 
			"\"No,\" said the man, \"I will eat and drink nothing.\"\r\n" + 
			"\r\n" + 
			"But she left him no peace, saying,\r\n" + 
			"\r\n" + 
			"\"Even if you eat nothing, take a draught out of this cup once and away.\"\r\n" + 
			"\r\n" + 
			"So he was over-persuaded, and he drank.\r\n" + 
			"\r\n" + 
			"In the afternoon, about two o'clock, he went out into the garden to\r\n" + 
			"stand upon the tan-heap and wait for the raven. As he stood there he\r\n" + 
			"felt all at once so tired, that he could bear it no longer, and laid\r\n" + 
			"himself down for a little; but not to sleep. But no sooner was he\r\n" + 
			"stretched at length than his eyes closed of themselves, and he fell\r\n" + 
			"asleep, and slept so sound, as if nothing in the world could awaken him.\r\n" + 
			"\r\n" + 
			"At two o'clock came the raven in the car drawn by four white horses, but\r\n" + 
			"she was sad, knowing already that the man would be asleep, and so, when\r\n" + 
			"she came into the garden, there he lay sure enough. And she got out of\r\n" + 
			"the car and shook him and called to him, but he did not wake. The next\r\n" + 
			"day at noon the old woman came and brought him meat and drink, but he\r\n" + 
			"would take none. But she left him no peace, and persuaded him until he\r\n" + 
			"took a draught out of the cup. About two o'clock he went into the garden\r\n" + 
			"to stand upon the tan-heap, and to wait for the raven, but he was\r\n" + 
			"overcome with so great a weariness that his limbs would no longer hold\r\n" + 
			"him up; and whether he would or no he had to lie down, and he fell into\r\n" + 
			"a deep sleep. And when the raven came up with her four red horses, she\r\n" + 
			"was sad, knowing already that the man would be asleep. And she went up\r\n" + 
			"to him, and there he lay, and nothing would wake him.\r\n" + 
			"\r\n" + 
			"The next day the old woman came and asked what was the matter with him,\r\n" + 
			"and if he wanted to die, that he would neither eat nor drink; but he\r\n" + 
			"answered,\r\n" + 
			"\r\n" + 
			"\"I neither can nor will eat and drink.\"\r\n" + 
			"\r\n" + 
			"But she brought the dishes of food and the cup of wine, and placed them\r\n" + 
			"before him, and when the smell came in his nostrils he could not\r\n" + 
			"refrain, but took a deep draught. When the hour drew near, he went into\r\n" + 
			"the garden and stood on the tan-heap to wait for the king's daughter; as\r\n" + 
			"time went on he grew more and more weary, and at last he laid himself\r\n" + 
			"down and slept like a stone. At two o'clock came the raven with four\r\n" + 
			"black horses, and the car and all was black; and she was sad, knowing\r\n" + 
			"already that he was sleeping, and would not be able to set her free; and\r\n" + 
			"when she came up to him, there he lay and slept. She shook him and\r\n" + 
			"called to him, but she could not wake him. Then she laid a loaf by his\r\n" + 
			"side and some meat, and a flask of wine, for now, however much he ate\r\n" + 
			"and drank, it could not matter. And she took a ring of gold from her\r\n" + 
			"finger, and put it on his finger, and her name was engraven on it. And\r\n" + 
			"lastly she laid by him a letter, in which was set down what she had\r\n" + 
			"given him, and that all was of no use, and further also it said,\r\n" + 
			"\r\n" + 
			"\"I see that here thou canst not save me, but if thy mind is to the\r\n" + 
			"thing, come to the golden castle of Stromberg: I know well that if thou\r\n" + 
			"willst thou canst.\" And when all this was done, she got again into her\r\n" + 
			"car, and went to the golden castle of Stromberg.\r\n" + 
			"\r\n" + 
			"When the man waked up and perceived that he had been to sleep, he was\r\n" + 
			"sad at heart to think that she had been, and gone, and that he had not\r\n" + 
			"set her free. Then, catching sight of what lay beside him, he read the\r\n" + 
			"letter that told him all. And he rose up and set off at once to go to\r\n" + 
			"the golden castle of Stromberg, though he knew not where it was. And\r\n" + 
			"when he had wandered about in the world for a long time, he came to a\r\n" + 
			"dark wood, and there spent a fortnight trying to find the way out, and\r\n" + 
			"not being able. At the end of this time, it being towards evening, he\r\n" + 
			"was so tired that he laid himself down under a clump of bushes and went\r\n" + 
			"to sleep. The next day he went on again, and in the evening, when he was\r\n" + 
			"going to lie down again to rest, he heard howlings and lamentations, so\r\n" + 
			"that he could not sleep. And about the hour when lamps are lighted, he\r\n" + 
			"looked up and saw a light glimmer in the forest; and he got up and\r\n" + 
			"followed it, and he found that it came from a house that looked very\r\n" + 
			"small indeed, because there stood a giant before it. And the man thought\r\n" + 
			"to himself that if he were to try to enter and the giant were to see\r\n" + 
			"him, it would go hard but he should lose his life. At last he made up\r\n" + 
			"his mind, and walked in. And the giant saw him.\r\n" + 
			"\r\n" + 
			"\"I am glad thou art come,\" said he; \"it is now a long time since I have\r\n" + 
			"had anything to eat; I shall make a good supper of thee.\"\r\n" + 
			"\r\n" + 
			"\"That may be,\" said the man, \"but I shall not relish it; besides, if\r\n" + 
			"thou desirest to eat, I have somewhat here that may satisfy thee.\"\r\n" + 
			"\r\n" + 
			"\"If that is true,\" answered the giant, \"thou mayest make thy mind easy;\r\n" + 
			"it was only for want of something better that I wished to devour thee.\"\r\n" + 
			"\r\n" + 
			"Then they went in and placed themselves at the table, and the man\r\n" + 
			"brought out bread, meat, and wine in plenty.\r\n" + 
			"\r\n" + 
			"\"This pleases me well,\" said the giant, and he ate to his heart's\r\n" + 
			"content. After a while the man asked him if he could tell him where the\r\n" + 
			"golden castle of Stromberg was.\r\n" + 
			"\r\n" + 
			"\"I will look on my land-chart,\" said the giant, \"for on it all towns and\r\n" + 
			"villages and houses are marked.\"\r\n" + 
			"\r\n" + 
			"So he fetched the land-chart which was in his room, and sought for the\r\n" + 
			"castle, but it was not to be found.\r\n" + 
			"\r\n" + 
			"\"Never mind,\" said he, \"I have up-stairs in the cupboard much bigger\r\n" + 
			"maps than this; we will have a look at them.\" And so they did, but in\r\n" + 
			"vain.\r\n" + 
			"\r\n" + 
			"And now the man wanted to pursue his journey, but the giant begged him\r\n" + 
			"to stay a few days longer, until his brother, who had gone to get in a\r\n" + 
			"store of provisions, should return. When the brother came, they asked\r\n" + 
			"him about the golden castle of Stromberg.\r\n" + 
			"\r\n" + 
			"\"When I have had time to eat a meal and be satisfied, I will look at the\r\n" + 
			"map.\"\r\n" + 
			"\r\n" + 
			"That being done, he went into his room with them, and they looked at his\r\n" + 
			"maps, but could find nothing: then he fetched other old maps, and they\r\n" + 
			"never left off searching until they found the golden castle of\r\n" + 
			"Stromberg, but it was many thousand miles away.\r\n" + 
			"\r\n" + 
			"\"How shall I ever get there?\" said the man.\r\n" + 
			"\r\n" + 
			"\"I have a couple of hours to spare,\" said the giant, \"and I will set you\r\n" + 
			"on your way, but I shall have to come back and look after the child that\r\n" + 
			"we have in the house with us.\"\r\n" + 
			"\r\n" + 
			"Then the giant bore the man until within about a hundred hours' journey\r\n" + 
			"from the castle, and saying,\r\n" + 
			"\r\n" + 
			"\"You can manage the rest of the way by yourself,\" he departed; and the\r\n" + 
			"man went on day and night, until at last he came to the golden castle of\r\n" + 
			"Stromberg. It stood on a mountain of glass, and he could see the\r\n" + 
			"enchanted Princess driving round it, and then passing inside the gates.\r\n" + 
			"He was rejoiced when he saw her, and began at once to climb the mountain\r\n" + 
			"to get to her; but it was so slippery, as fast as he went he fell back\r\n" + 
			"again. And when he saw this he felt he should never reach her, and he\r\n" + 
			"was full of grief, and resolved at least to stay at the foot of the\r\n" + 
			"mountain and wait for her. So he built himself a hut, and sat there and\r\n" + 
			"waited a whole year; and every day he saw the Princess drive round and\r\n" + 
			"pass in, and was never able to reach her.\r\n" + 
			"\r\n" + 
			"One day he looked out of his hut and saw three robbers fighting, and he\r\n" + 
			"called out, \"Mercy on us!\" Hearing a voice, they stopped for a moment,\r\n" + 
			"but went on again beating one another in a dreadful manner. And he cried\r\n" + 
			"out again, \"Mercy on us!\" They stopped and listened, and looked about\r\n" + 
			"them, and then went on again. And he cried out a third time, \"Mercy on\r\n" + 
			"us!\" and then, thinking he would go and see what was the matter, he went\r\n" + 
			"out and asked them what they were fighting for. One of them told him he\r\n" + 
			"had found a stick which would open any door only by knocking at it; the\r\n" + 
			"second said he had found a cloak which, if he put it on, made him\r\n" + 
			"invisible; the third said he was possessed of a horse that would ride\r\n" + 
			"over everything, even the glass mountain. Now they had fought because\r\n" + 
			"they could not agree whether they should enjoy these things in common or\r\n" + 
			"separately.\r\n" + 
			"\r\n" + 
			"\"Suppose we make a bargain,\" said the man; \"it is true I have no money,\r\n" + 
			"but I have other things yet more valuable to exchange for these; I must,\r\n" + 
			"however, make trial of them beforehand, to see if you have spoken truth\r\n" + 
			"concerning them.\"\r\n" + 
			"\r\n" + 
			"So they let him mount the horse, and put the cloak round him, and they\r\n" + 
			"gave him the stick into his hand, and as soon as he had all this he was\r\n" + 
			"no longer to be seen; but laying about him well, he gave them all a\r\n" + 
			"sound thrashing, crying out,\r\n" + 
			"\r\n" + 
			"\"Now, you good-for-nothing fellows, you have got what you deserve;\r\n" + 
			"perhaps you will be satisfied now!\"\r\n" + 
			"\r\n" + 
			"Then he rode up the glass mountain, and when he reached the castle gates\r\n" + 
			"he found them locked; but he beat with his stick upon the door and it\r\n" + 
			"opened at once. And he walked in, and up the stairs to the great room\r\n" + 
			"where sat the Princess with a golden cup and wine before her: she could\r\n" + 
			"not see him so long as the cloak was on him, but drawing near to her he\r\n" + 
			"pulled off the ring she had given him, and threw it into the cup with a\r\n" + 
			"clang.\r\n" + 
			"\r\n" + 
			"\"This is my ring,\" she cried, \"and the man who is to set me free must be\r\n" + 
			"here too!\"\r\n" + 
			"\r\n" + 
			"But though she sought through the whole castle she found him not; he had\r\n" + 
			"gone outside, seated himself on his horse, and thrown off the cloak. And\r\n" + 
			"when she came to look out at the door, she saw him and shrieked out for\r\n" + 
			"joy; and he dismounted and took her in his arms, and she kissed him,\r\n" + 
			"saying,\r\n" + 
			"\r\n" + 
			"\"Now hast thou set me free from my enchantment, and to-morrow we will be\r\n" + 
			"married.\"";
	
	private static String mysteryText2 = "FAITHFUL JOHN\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"THERE was once an old King, who, having fallen sick, thought to himself,\r\n" + 
			"\"This is very likely my death-bed on which I am lying.\"\r\n" + 
			"\r\n" + 
			"Then he said, \"Let Faithful John be sent for.\"\r\n" + 
			"\r\n" + 
			"Faithful John was his best-beloved servant, and was so called because he\r\n" + 
			"had served the King faithfully all his life long. When he came near the\r\n" + 
			"bed, the King said to him,\r\n" + 
			"\r\n" + 
			"\"Faithful John, I feel my end drawing near, and my only care is for my\r\n" + 
			"son; he is yet of tender years, and does not always know how to shape\r\n" + 
			"his conduct; and unless you promise me to instruct him in all his\r\n" + 
			"actions and be a true foster-father to him, I shall not be able to close\r\n" + 
			"my eyes in peace.\"\r\n" + 
			"\r\n" + 
			"Then answered Faithful John, \"I will never forsake him, and will serve\r\n" + 
			"him faithfully, even though it should cost me my life.\"\r\n" + 
			"\r\n" + 
			"And the old King said, \"Then I die, being of good cheer and at peace.\"\r\n" + 
			"And he went on to say,\r\n" + 
			"\r\n" + 
			"\"After my death, you must lead him through the whole castle, into all\r\n" + 
			"the chambers, halls, and vaults, and show him the treasures that in them\r\n" + 
			"lie; but the last chamber in the long gallery, in which lies hidden the\r\n" + 
			"picture of the Princess of the Golden Palace, you must not show him. If\r\n" + 
			"he were to see that picture, he would directly fall into so great a love\r\n" + 
			"for her, that he would faint with the strength of it, and afterwards for\r\n" + 
			"her sake run into great dangers; so you must guard him well.\"\r\n" + 
			"\r\n" + 
			"And as Faithful John gave him his hand upon it, the old King became\r\n" + 
			"still and silent, laid his head upon the pillow, and died.\r\n" + 
			"\r\n" + 
			"When the old King was laid in the grave, Faithful John told the young\r\n" + 
			"King what he had promised to his father on his death-bed, and said,\r\n" + 
			"\r\n" + 
			"\"And I will certainly hold to my promise and be faithful to you, as I\r\n" + 
			"was faithful to him, even though it should cost me my life.\"\r\n" + 
			"\r\n" + 
			"When the days of mourning were at an end, Faithful John said to the\r\n" + 
			"Prince,\r\n" + 
			"\r\n" + 
			"\"It is now time that you should see your inheritance; I will show you\r\n" + 
			"all the paternal castle.\"\r\n" + 
			"\r\n" + 
			"Then he led him over all the place, upstairs and down-stairs, and showed\r\n" + 
			"him all the treasures and the splendid chambers; one chamber only he did\r\n" + 
			"not open, that in which the perilous picture hung. Now the picture was\r\n" + 
			"so placed that when the door opened it was the first thing to be seen,\r\n" + 
			"and was so wonderfully painted that it seemed to breathe and move, and\r\n" + 
			"in the whole world was there nothing more lovely or more beautiful. The\r\n" + 
			"young King noticed how Faithful John always passed by this one door, and\r\n" + 
			"asked,\r\n" + 
			"\r\n" + 
			"\"Why do you not undo this door?\"\r\n" + 
			"\r\n" + 
			"\"There is something inside that would terrify you,\" answered he. But the\r\n" + 
			"King answered,\r\n" + 
			"\r\n" + 
			"\"I have seen the whole castle, and I will know what is in here also.\"\r\n" + 
			"And he went forward and tried to open the door by force.\r\n" + 
			"\r\n" + 
			"Then Faithful John called him back, and said, \"I promised your father on\r\n" + 
			"his death-bed that you should not see what is in that room; it might\r\n" + 
			"bring great misfortune on you and me were I to break my promise.\"\r\n" + 
			"\r\n" + 
			"But the young King answered, \"I shall be undone if I do not go inside\r\n" + 
			"that room; I shall have no peace day or night until I have seen it with\r\n" + 
			"these eyes; and I will not move from this place until you have unlocked\r\n" + 
			"it.\"\r\n" + 
			"\r\n" + 
			"Then Faithful John saw there was no help for it, and he chose out the\r\n" + 
			"key from the big bunch with a heavy heart and many sighs. When the door\r\n" + 
			"was opened he walked in first, and thought that by standing in front of\r\n" + 
			"the King he might hide the picture from him, but that was no good, the\r\n" + 
			"King stood on tiptoe, and looked over his shoulder. And when he saw the\r\n" + 
			"image of the lady that was so wonderfully beautiful, and so glittering\r\n" + 
			"with gold and jewels, he fell on the ground powerless. Faithful John\r\n" + 
			"helped him up, took him to his bed, and thought with sorrow, \"Ah me! the\r\n" + 
			"evil has come to pass; what will become of us?\"\r\n" + 
			"\r\n" + 
			"Then he strengthened the King with wine, until he came to himself. The\r\n" + 
			"first words that he said were,\r\n" + 
			"\r\n" + 
			"\"Oh, the beautiful picture! whose portrait is it?\"\r\n" + 
			"\r\n" + 
			"\"It is the portrait of the Princess of the Golden Palace,\" answered\r\n" + 
			"Faithful John. Then the King said,\r\n" + 
			"\r\n" + 
			"\"My love for her is so great that if all the leaves of the forest were\r\n" + 
			"tongues they could not utter it! I stake my life on the chance of\r\n" + 
			"obtaining her, and you, my Faithful John, must stand by me.\"\r\n" + 
			"\r\n" + 
			"The faithful servant considered for a long time how the business should\r\n" + 
			"be begun; it seemed to him that it would be a difficult matter to come\r\n" + 
			"only at a sight of the Princess. At last he thought out a way, and said\r\n" + 
			"to the King,\r\n" + 
			"\r\n" + 
			"\"All that she has about her is of gold--tables, chairs, dishes,\r\n" + 
			"drinking-cups, bowls, and all the household furniture; in your treasury\r\n" + 
			"are five tons of gold, let the goldsmiths of your kingdom work it up\r\n" + 
			"into all kinds of vessels and implements, into all kinds of birds, and\r\n" + 
			"wild creatures, and wonderful beasts, such as may please her; then we\r\n" + 
			"will carry them off with us, and go and seek our fortune.\"\r\n" + 
			"\r\n" + 
			"The King had all the goldsmiths fetched, and they worked day and night,\r\n" + 
			"until at last some splendid things were got ready. When a ship had been\r\n" + 
			"loaded with them, Faithful John put on the garb of a merchant, and so\r\n" + 
			"did the King, so as the more completely to disguise themselves. Then\r\n" + 
			"they journeyed over the sea, and went so far that at last they came to\r\n" + 
			"the city where the Princess of the Golden Palace dwelt.\r\n" + 
			"\r\n" + 
			"Faithful John told the King to stay in the ship, and to wait for him.\r\n" + 
			"\r\n" + 
			"\"Perhaps,\" said he, \"I shall bring the Princess back with me, so take\r\n" + 
			"care that everything is in order; let the golden vessels be placed\r\n" + 
			"about, and the whole ship be adorned.\"\r\n" + 
			"\r\n" + 
			"Then he gathered together in his apron some of the gold things, one of\r\n" + 
			"each kind, landed, and went up to the royal castle. And when he reached\r\n" + 
			"the courtyard of the castle there stood by the well a pretty maiden, who\r\n" + 
			"had two golden pails in her hand, and she was drawing water with them;\r\n" + 
			"and as she turned round to carry them away she saw the strange man, and\r\n" + 
			"asked him who he was. He answered,\r\n" + 
			"\r\n" + 
			"\"I am a merchant,\" and opened his apron, and let her look within it.\r\n" + 
			"\r\n" + 
			"\"Ah, what beautiful things!\" cried she, and setting down her pails, she\r\n" + 
			"turned the golden toys over, and looked at them one after another: then\r\n" + 
			"she said,\r\n" + 
			"\r\n" + 
			"\"The Princess must see these; she takes so much pleasure in gold things\r\n" + 
			"that she will buy them all from you.\"\r\n" + 
			"\r\n" + 
			"Then she took him by the hand and led him in, for she was the\r\n" + 
			"chamber-maid.\r\n" + 
			"\r\n" + 
			"When the Princess saw the golden wares she was very pleased, and said,\r\n" + 
			"\r\n" + 
			"\"All these are so finely worked that I should like to buy them of you.\"\r\n" + 
			"\r\n" + 
			"But the faithful John said,\r\n" + 
			"\r\n" + 
			"\"I am only the servant of a rich merchant, and what I have here is\r\n" + 
			"nothing to what my master has in the ship--the cunningest and costliest\r\n" + 
			"things that ever were made of gold.\"\r\n" + 
			"\r\n" + 
			"The Princess then wanted it all to be brought to her; but he said,\r\n" + 
			"\r\n" + 
			"\"That would take up many days; so great is the number of them, and so\r\n" + 
			"much space would they occupy that there would not be enough room for\r\n" + 
			"them in your house.\"\r\n" + 
			"\r\n" + 
			"But the Princess's curiosity and fancy grew so much that at last she\r\n" + 
			"said,\r\n" + 
			"\r\n" + 
			"\"Lead me to the ship; I will myself go and see your master's treasures.\"\r\n" + 
			"\r\n" + 
			"Then Faithful John led her to the ship joyfully, and the King, when he\r\n" + 
			"saw that her beauty was even greater than the picture had set forth,\r\n" + 
			"felt his heart leap at the sight. Then she climbed up into the ship, and\r\n" + 
			"the King received her. Faithful John stayed by the steersman, and gave\r\n" + 
			"orders for the ship to push off, saying, \"Spread all sail, that she may\r\n" + 
			"fly like a bird in the air.\"\r\n" + 
			"\r\n" + 
			"So the King showed her all the golden things, each separately--the\r\n" + 
			"dishes, the bowls, the birds, the wild creatures, and the wonderful\r\n" + 
			"beasts. Many hours were passed in looking at them all, and in her\r\n" + 
			"pleasure the Princess never noticed that the ship was moving onwards.\r\n" + 
			"When she had examined the last, she thanked the merchant, and prepared\r\n" + 
			"to return home; but when she came to the ship's side, she saw that they\r\n" + 
			"were on the high seas, far from land, and speeding on under full sail.\r\n" + 
			"\r\n" + 
			"\"Ah!\" cried she, full of terror, \"I am betrayed and carried off by this\r\n" + 
			"merchant. Oh that I had died rather than have fallen into his power!\"\r\n" + 
			"\r\n" + 
			"But the King took hold of her hand, and said,\r\n" + 
			"\r\n" + 
			"\"No merchant am I, but a King, and no baser of birth than thyself; it is\r\n" + 
			"because of my over-mastering love for thee that I have carried thee off\r\n" + 
			"by cunning. The first time I saw thy picture I fell fainting to the\r\n" + 
			"earth.\"\r\n" + 
			"\r\n" + 
			"When the Princess of the Golden Palace heard this she became more\r\n" + 
			"trustful, and her heart inclined favourably towards him, so that she\r\n" + 
			"willingly consented to become his wife.\r\n" + 
			"\r\n" + 
			"It happened, however, as they were still journeying on the open sea,\r\n" + 
			"that Faithful John, as he sat in the forepart of the ship and made\r\n" + 
			"music, caught sight of three ravens in the air flying overhead. Then he\r\n" + 
			"stopped playing, and listened to what they said one to another, for he\r\n" + 
			"understood them quite well. The first one cried,\r\n" + 
			"\r\n" + 
			"\"Ay, there goes the Princess of the Golden Palace.\"\r\n" + 
			"\r\n" + 
			"\"Yes,\" answered the second; \"but he has not got her safe yet.\" And the\r\n" + 
			"third said,\r\n" + 
			"\r\n" + 
			"\"He has her, though; she sits beside him in the ship.\"\r\n" + 
			"\r\n" + 
			"Then the first one spoke again,\r\n" + 
			"\r\n" + 
			"\"What does that avail him? When they come on land a fox-red horse will\r\n" + 
			"spring towards them; then will the King try to mount him; and if he\r\n" + 
			"does, the horse will rise with him into the air, so that he will never\r\n" + 
			"see his bride again.\" The second raven asked,\r\n" + 
			"\r\n" + 
			"\"Is there no remedy?\"\r\n" + 
			"\r\n" + 
			"\"Oh yes; if another man mounts quickly, and takes the pistol out of the\r\n" + 
			"holster and shoots the horse dead with it, he will save the young King.\r\n" + 
			"But who knows that? and he that knows it and does it will become stone\r\n" + 
			"from toe to knee.\" Then said the second,\r\n" + 
			"\r\n" + 
			"\"I know further, that if the horse should be killed, the young King will\r\n" + 
			"not even then be sure of his bride. When they arrive at the castle there\r\n" + 
			"will lie a wrought bride-shirt in a dish, and it will seem all woven of\r\n" + 
			"gold and silver, but it is really of sulphur and pitch, and if he puts\r\n" + 
			"it on it will burn him to the marrow of his bones.\" The third raven\r\n" + 
			"said,\r\n" + 
			"\r\n" + 
			"\"Is there no remedy?\"\r\n" + 
			"\r\n" + 
			"\"Oh yes,\" answered the second; \"if another man with gloves on picks up\r\n" + 
			"the shirt, and throws it into the fire, so that it is consumed, then is\r\n" + 
			"the young King delivered. But what avails that? He who knows it and does\r\n" + 
			"it will be turned into stone from his heart to his knee.\" Then spoke the\r\n" + 
			"third,\r\n" + 
			"\r\n" + 
			"\"I know yet more, that even when the bride-shirt is burnt up the King is\r\n" + 
			"not sure of his bride; when at the wedding the dance begins, and the\r\n" + 
			"young Queen dances, she will suddenly grow pale and fall to the earth as\r\n" + 
			"if she were dead, and unless some one lifts her up and takes three drops\r\n" + 
			"of blood from her right breast, she will die. But he that knows this and\r\n" + 
			"does this will become stone from the crown of his head to the sole of\r\n" + 
			"his foot.\"\r\n" + 
			"\r\n" + 
			"When the ravens had spoken thus among themselves they flew away.\r\n" + 
			"Faithful John had understood it all, and from that time he remained\r\n" + 
			"quiet and sad, for he thought to himself that were he to conceal what he\r\n" + 
			"had heard from his master, misfortune would befall; and were he to\r\n" + 
			"discover it his own life would be sacrificed. At last, however, he said\r\n" + 
			"within himself,\r\n" + 
			"\r\n" + 
			"\"I will save my master, though I myself should perish!\"\r\n" + 
			"\r\n" + 
			"So when they came on land, it happened just as the ravens had foretold,\r\n" + 
			"there sprang forward a splendid fox-red horse.\r\n" + 
			"\r\n" + 
			"\"Come on!\" said the King, \"he shall carry me to the castle,\" and was\r\n" + 
			"going to mount, when Faithful John passed before him and mounted\r\n" + 
			"quickly, drew the pistol out of the holster, and shot the horse dead.\r\n" + 
			"Then the other servants of the king cried out (for they did not wish\r\n" + 
			"well to Faithful John),\r\n" + 
			"\r\n" + 
			"\"How shameful to kill that beautiful animal that was to have carried the\r\n" + 
			"king to his castle.\" But the King said,\r\n" + 
			"\r\n" + 
			"\"Hold your tongues, and let him be: he is my Faithful John; he knows\r\n" + 
			"what is the good of it.\"\r\n" + 
			"\r\n" + 
			"Then they went up to the castle, and there stood in the hall a dish,\r\n" + 
			"and the wrought bride-shirt that lay on it seemed as if of gold and\r\n" + 
			"silver. The young King went up to it and was going to put it on, but\r\n" + 
			"Faithful John pushed him away, picked it up with his gloved hands, threw\r\n" + 
			"it quickly on the fire, and there let it burn. The other servants began\r\n" + 
			"grumbling again, and said,\r\n" + 
			"\r\n" + 
			"\"Look, he is even burning up the king's bridal shirt!\" But the young\r\n" + 
			"King said,\r\n" + 
			"\r\n" + 
			"\"Who knows but that there may be a good reason for it? let him be, he is\r\n" + 
			"my Faithful John.\"\r\n" + 
			"\r\n" + 
			"Then the wedding feast was held; and the bride led the dance; Faithful\r\n" + 
			"John watched her carefully, and all at once she grew pale and fell down\r\n" + 
			"as if she were dead. Then he went quickly to her, and carried her into a\r\n" + 
			"chamber hard by, laid her down, and kneeling, took three drops of blood\r\n" + 
			"from her right breast. Immediately she drew breath again and raised\r\n" + 
			"herself up, but the young King witnessing all, and not knowing why\r\n" + 
			"Faithful John had done this, grew very angry, and cried out,\r\n" + 
			"\r\n" + 
			"\"Throw him into prison!\"\r\n" + 
			"\r\n" + 
			"The next morning Faithful John was condemned to death and led to the\r\n" + 
			"gallows, and as he stood there ready to suffer, he said,\r\n" + 
			"\r\n" + 
			"\"He who is about to die is permitted to speak once before his end; may I\r\n" + 
			"claim that right?\"\r\n" + 
			"\r\n" + 
			"\"Yes,\" answered the King, \"it is granted to you.\" Then said Faithful\r\n" + 
			"John,\r\n" + 
			"\r\n" + 
			"\"I have been condemned unjustly, for I have always been faithful,\" and\r\n" + 
			"he related how he had heard on the sea voyage the talk of the ravens,\r\n" + 
			"and how he had done everything in order to save his master. Then cried\r\n" + 
			"the King,\r\n" + 
			"\r\n" + 
			"\"O my Faithful John, pardon! pardon! lead him down!\" But Faithful John,\r\n" + 
			"as he spoke the last words, fell lifeless, and became stone.\r\n" + 
			"\r\n" + 
			"The King and Queen had great grief because of this, and the King said,\r\n" + 
			"\r\n" + 
			"\"Ah, how could I have evil-rewarded such faithfulness!\" and he caused\r\n" + 
			"the stone image to be lifted up and put to stand in his sleeping-room by\r\n" + 
			"the side of his bed. And as often as he saw it he wept and said,\r\n" + 
			"\r\n" + 
			"\"Would that I could bring thee back to life, my Faithful John!\"\r\n" + 
			"\r\n" + 
			"After some time the Queen bore twins--two little sons--that grew and\r\n" + 
			"thrived, and were the joy of their parents. One day, when the Queen was\r\n" + 
			"in church, the two children were sitting and playing with their father,\r\n" + 
			"and he gazed at the stone image full of sadness, sighed, and cried,\r\n" + 
			"\r\n" + 
			"\"Oh that I could bring thee back to life, my Faithful John!\" Then the\r\n" + 
			"stone began to speak, and said,\r\n" + 
			"\r\n" + 
			"\"Yes, thou canst bring me back to life again, if thou wilt bestow\r\n" + 
			"therefor thy best-beloved.\" Then cried the King,\r\n" + 
			"\r\n" + 
			"\"All that I have in the world will I give up for thee!\" The stone went\r\n" + 
			"on to say,\r\n" + 
			"\r\n" + 
			"\"If thou wilt cut off the heads of thy two children with thy own hand,\r\n" + 
			"and besmear me with their blood, I shall receive life again.\"\r\n" + 
			"\r\n" + 
			"The King was horror-struck at the thought that he must put his beloved\r\n" + 
			"children to death, but he remembered all John's faithfulness, and how he\r\n" + 
			"had died for him, and he drew his sword and cut off his children's heads\r\n" + 
			"with his own hand. And when he had besmeared the stone with their blood\r\n" + 
			"life returned to it, and Faithful John stood alive and well before him;\r\n" + 
			"and he said to the king,\r\n" + 
			"\r\n" + 
			"\"Thy faithfulness shall not be unrewarded,\" and, taking up the heads of\r\n" + 
			"the children, he set them on again, and besmeared the wound with their\r\n" + 
			"blood, upon which in a moment they were whole again, and jumped about,\r\n" + 
			"and went on playing as if nothing had happened to them.\r\n" + 
			"\r\n" + 
			"Now was the King full of joy; and when he saw the Queen coming he put\r\n" + 
			"the Faithful John and the two children in a great chest. When she came\r\n" + 
			"in he said to her,\r\n" + 
			"\r\n" + 
			"\"Hast thou prayed in church?\"\r\n" + 
			"\r\n" + 
			"\"Yes,\" answered she, \"but I was thinking all the while of Faithful John,\r\n" + 
			"and how he came to such great misfortune through us.\"\r\n" + 
			"\r\n" + 
			"\"Then,\" said he, \"dear wife, we can give him life again, but it will\r\n" + 
			"cost us both our little sons, whom we must sacrifice.\"\r\n" + 
			"\r\n" + 
			"The Queen grew pale and sick at heart, but said,\r\n" + 
			"\r\n" + 
			"\"We owe it him, because of his great faithfulness.\"\r\n" + 
			"\r\n" + 
			"Then the King rejoiced because she thought as he did, and he went and\r\n" + 
			"unlocked the chest and took out the children and Faithful John, and\r\n" + 
			"said,\r\n" + 
			"\r\n" + 
			"\"God be praised, he is delivered, and our little sons are ours again;\"\r\n" + 
			"and he related to her how it had come to pass.\r\n" + 
			"\r\n" + 
			"After that they all lived together in happiness to their lives' end.";
	
	private static String mysteryText3 = 
			"It had been agreed that the one who should bring water first from a far\r\n" + 
			"distant brook should be accounted winner. Now the king's daughter and\r\n" + 
			"the runner each took a pitcher, and they started both at the same time;\r\n" + 
			"but in one moment, when the king's daughter had gone but a very little\r\n" + 
			"way, the runner was out of sight, for his running was as if the wind\r\n" + 
			"rushed by.";
	
	
	
	public static InputStream initMysteryText(int text) {
		String mysteryText = text == 1 ? mysteryText1 : (text == 2 ? mysteryText2 : mysteryText3);
		return new ByteArrayInputStream(mysteryText.getBytes());
		
	}
}
	
	