package bg.sofia.uni.fmi.mjt.youtube;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.youtube.model.TrendingVideo;

public class YoutubeTrendsExplorerTest {

	private static List<TrendingVideo> videos;
	private static YoutubeTrendsExplorer explorer;
	private static final String LEAST_LIKED_VIDEO_ID = "KWn4JmiM2pM";
	private static final String MOST_LIKED_LEAST_DISLIKED_VIDEO_ID = "kTlv5_Bs8aw";
	private static final String FIRST_TOP_VIDEO_TITLE = "BTS (방탄소년단) 'MIC Drop (Steve Aoki Remix)' Official MV";
	private static final String SECOND_TOP_VIDEO_TITLE = "Casually Explained: Levels of Wealth";
	private static final String THIRD_TOP_VIDEO_TITLE = "Calum Scott - You Are The Reason (Lyric Video)";
	private static final String MOST_TAGGED_VIDEO_ID = "JbQ4MwDdxSU";
	private static final String FIRST_BEFORE_100K_VIDEO_ID = "Downtown | The Cuddle Squad";
	private static final String MOST_TRENDING_VIDEO_ID = "kTlv5_Bs8aw";

	@BeforeClass
	public static void setUp() {
		String[] vid = {
            "video_id	trending_date	title	publish_time	tags	views	likes	dislikes"
                + "									\r\n"
				+ "J0VUaYYK-zk	17.01.12	Downtown | The Cuddle Squad	2017-11-27T18:22:09."
				+ "000Z	\"Downtown|\"\"Petula Clark\"\"|\"\"PArody\"\"|\"\"parody\"\"|\"\"co"
				+ "medy\"\"|\"\"sketch\"\"|\"\"the cuddle squad\"\"|\"\"hammered\"\"|\"\"imp"
				+ "rov\"\"|\"\"SNL\"\"|\"\"NYC\"\"|\"\"Austin\"\"|\"\"texas\"\"|\"\"LA\"\"|"
				+ "\"\"UCB\"\"|\"\"macklemore\"\"|\"\"ryan lewis\"\"|\"\"ffFdowntown officia"
				+ "l music video\"\"|\"\"song parody\"\"\"	48014	789	84					"
				+ "				\r\n"
				+ "JANApS0P4z8	17.01.12	Casually Explained: Levels of Wealth	2017-11-"
				+ "25T15:00:03.000Z	\"casually explained|\"\"wealth\"\"|\"\"levels of wealth"
				+ "\"\"|\"\"richest people\"\"|\"\"1%\"\"|\"\"99%\"\"|\"\"99% and 1%\"\"|\""
				+ "\"rich vs poor\"\"|\"\"socioeconomic status\"\"|\"\"wealth pyramid\"\"|"
				+ "\"\"money\"\"|\"\"how to get rich\"\"|\"\"does money make you happy\"\"|"
				+ "\"\"are rich people happier\"\"|\"\"comedy\"\"|\"\"stand up comedy\"\"|\""
				+ "\"animation\"\"|\"\"animated comedy\"\"\"	2836959	115670	3981		"
				+ "							\r\n"
				+ "JbQ4MwDdxSU	17.01.12	Texans vs. Ravens | NFL Week 12 Game Highlights	"
				+ "2017-11-28T05:02:37.000Z	\"NFL|\"\"Football\"\"|\"\"offense\"\"|\"\"defen"
				+ "se\"\"|\"\"afc\"\"|\"\"nfc\"\"|\"\"American Football\"\"|\"\"highlight\""
				+ "\"|\"\"highlights\"\"|\"\"game\"\"|\"\"games\"\"|\"\"sport\"\"|\"\"sports"
				+ "\"\"|\"\"action\"\"|\"\"play\"\"|\"\"plays\"\"|\"\"season\"\"|\"\"2017\""
				+ "\"|\"\"recap\"\"|\"\"run\"\"|\"\"sprint\"\"|\"\"catch\"\"|\"\"huge\"\"|\""
				+ "\"amazing\"\"|\"\"touchdown\"\"|\"\"td\"\"|\"\"week 12\"\"|\"\"wk 12\"\"|"
				+ "\"\"houston\"\"|\"\"texans\"\"|\"\"baltimore\"\"|\"\"ravens\"\"|\"\"mnf\""
				+ "\"|\"\"monday night football\"\"|\"\"hopkins\"\"|\"\"savage\"\"|\"\"suggs"
				+ "\"\"|\"\"flacco\"\"|\"\"allen\"\"|\"\"collins\"\"|\"\"post game highlight"
				+ "s\"\"|\"\"ravens win\"\"|\"\"td drive\"\"|\"\"sp:dt=2017-11-27T20:30:00-0"
				+ "5:00\"\"|\"\"sp:vl=en-US\"\"|\"\"sp:st=football\"\"|\"\"sp:li=nfl\"\"|\""
				+ "\"sp:ti:home=Bal\"\"|\"\"sp:ti:away=Hou\"\"|\"\"sp:ty=high\"\"\"	620204	"
				+ "4774	268									\r\n"
				+ "kTlv5_Bs8aw	17.01.12	BTS (방탄소년단) 'MIC Drop (Steve Aoki Remix)' Offi"
				+ "cial MV	2017-11-24T09:00:02.000Z	\"BIGHIT|\"\"빅히트\"\"|\"\"방탄소년단\""
				+ "\"|\"\"BTS\"\"|\"\"BANGTAN\"\"|\"\"방탄\"\"\"	36857298	2729292	47896	"
				+ "								\r\n"
				+ "JcC5VGOx8I8	17.01.12	Calum Scott - You Are The Reason (Lyric Video)	"
				+ "2017-11-24T00:00:01.000Z	\"Pop|\"\"calum scott\"\"|\"\"you are the reason"
				+ "\"\"|\"\"you are the reason lyrics\"\"|\"\"only human\"\"|\"\"dancing on "
				+ "my own\"\"|\"\"britains got talent\"\"\"	1728219	80272	425				"
				+ "					\r\n"
				+ "JDK3l9TmwAo	17.01.12	\"Top 10 Plays of the Night: November 28, 2017\""
				+ "	2017-11-29T06:34:31.000Z	\"nba|\"\"highlights\"\"|\"\"basketball\"\"|"
				+ "\"\"plays\"\"|\"\"amazing\"\"|\"\"sports\"\"|\"\"hoops\"\"|\"\"finals\"\""
				+ "|\"\"games\"\"|\"\"game\"\"|\"\"top\"\"|\"\"top 10\"\"|\"\"play\"\"|\"\"n"
				+ "ight\"\"|\"\"best\"\"|\"\"thabo\"\"|\"\"sefolosha\"\"|\"\"bogdan\"\"|\"\""
				+ "bogdanovic\"\"|\"\"lebron\"\"|\"\"james\"\"|\"\"eric\"\"|\"\"bledsoe\"\"|"
				+ "\"\"mike\"\"|\"\"tyler\"\"|\"\"ulis\"\"|\"\"kelly\"\"|\"\"oubre\"\"|\"\"j"
				+ "r\"\"|\"\"j.r.\"\"|\"\"giannis\"\"|\"\"antetokounmpo\"\"|\"\"de'aaron\"\""
				+ "|\"\"fox\"\"\"	307934	2673	1645									"
				+ "\r\n"
				+ "jLZuaFZWa7A	17.01.12	Can you guess these WWE Superstars?	2017-11-24T2"
				+ "0:30:01.000Z	\"wwe|\"\"world wrestling entertainment\"\"|\"\"wrestling\""
				+ "\"|\"\"wrestler\"\"|\"\"wrestle\"\"|\"\"superstars\"\"|\"\"|\"\"Kalisto\""
				+ "\"|\"\"Sasha Banks\"\"|\"\"Triple H\"\"|\"\"Fandango\"\"|\"\"Alicia Fox\""
				+ "\"|\"\"Goldberg\"\"|\"\"Roman Reigns\"\"|\"\"Jerry the King\"\"|\"\"Lawle"
				+ "r\"\"|\"\"Charlotte Flair\"\"|\"\"Paul Heyman\"\"|\"\"wwe superstars\"\"|"
				+ "\"\"raw\"\"|\"\"wwe quiz\"\"|\"\"smackdown\"\"|\"\"wwe wrestlers\"\"|\"\""
				+ "game\"\"|\"\"wwe trivia\"\"|\"\"guessing game\"\"|\"\"john cena\"\"|\"\"w"
				+ "we top 10\"\"|\"\"funny games\"\"\"	746691	19242	961					"
				+ "				\r\n"
				+ "k_aT3jAK_QU	17.01.12	Justin Timberlake And Stephen Harmonize The Nati"
				+ "onal Anthem	2017-11-30T08:35:00.000Z	\"The Late Show|\"\"Stephen Colb"
				+ "ert\"\"|\"\"Colbert\"\"|\"\"Late Show\"\"|\"\"celebrities\"\"|\"\"late ni"
				+ "ght\"\"|\"\"talk show\"\"|\"\"skits\"\"|\"\"bit\"\"|\"\"monologue\"\"|\""
				+ "\"The Late Late Show\"\"|\"\"Late Late Show\"\"|\"\"letterman\"\"|\"\"dav"
				+ "id letterman\"\"|\"\"comedian\"\"|\"\"impressions\"\"|\"\"CBS\"\"|\"\"jok"
				+ "e\"\"|\"\"jokes\"\"|\"\"funny\"\"|\"\"funny video\"\"|\"\"funny videos\""
				+ "\"|\"\"humor\"\"|\"\"celebrity\"\"|\"\"celeb\"\"|\"\"hollywood\"\"|\"\"fa"
				+ "mous\"\"|\"\"James Corden\"\"|\"\"Corden\"\"|\"\"Comedy\"\"\"	372262	"
				+ "3332	286									\r\n"
				+ "kehML-RAkd4	17.01.12	Magic MAGNETIC Nail Polish?!  (maybe don't wear "
				+ "metal)	2017-11-29T21:51:37.000Z	\"nails|\"\"nail art\"\"|\"\"nail tu"
				+ "torial\"\"|\"\"beauty tutorial\"\"|\"\"nail art tutorial\"\"|\"\"diy nail"
				+ "s\"\"|\"\"easy nail art\"\"|\"\"diy nail art\"\"|\"\"cute nail art\"\"|\""
				+ "\"simply nailogical\"\"|\"\"magnetic\"\"|\"\"magnetic nails\"\"|\"\"magnet"
				+ "ic nail polish\"\"|\"\"multi-chrome\"\"|\"\"multi-chrome nails\"\"|\"\"col"
				+ "our changing\"\"|\"\"color changing nails\"\"|\"\"magic nails\"\"|\"\"magi"
				+ "c nail polish\"\"|\"\"moving nails\"\"|\"\"fun lacquer\"\"|\"\"shifting na"
				+ "ils\"\"|\"\"color shifting\"\"|\"\"mood paint\"\"|\"\"mood nails\"\"\"	1"
				+ "538576	81240	678									\r\n"
				+ "KrxDhokzEv4	17.01.12	Razer Phone Durability test - Scratch BURN and BE"
				+ "ND tested!	2017-11-27T15:27:42.000Z	\"Razer Phone|\"\"razerphone\"\"|"
				+ "\"\"razor phone\"\"|\"\"gaming phone\"\"|\"\"android\"\"|\"\"Razer gaming"
				+ "\"\"|\"\"best smartphone\"\"|\"\"tech\"\"|\"\"mobile device\"\"|\"\"mobile"
				+ " tech\"\"|\"\"Razer\"\"|\"\"120hz display\"\"\"	713491	23812	770		"
				+ "							\r\n"
				+ "kTlv5_Bs8aw	17.01.12	BTS (방탄소년단) 'MIC Drop (Steve Aoki Remix)' Offic"
				+ "ial MV	2017-11-24T09:00:02.000Z	\"BIGHIT|\"\"빅히트\"\"|\"\"방탄소년단\"\""
				+ "|\"\"BTS\"\"|\"\"BANGTAN\"\"|\"\"방탄\"\"\"	36857298	2729292	47896	"
				+ "								\r\n"
				+ "KWn4JmiM2pM	17.01.12	Grammys 2018 Nominations Announced | Billboard Ne"
				+ "ws	2017-11-28T14:52:38.000Z	\"billboard news|\"\"billboard\"\"|\"\"of"
				+ "ficial billboard channel\"\"|\"\"billboard channel\"\"|\"\"official\"\"|\""
				+ "\"news\"\"|\"\"music\"\"|\"\"entertainment\"\"|\"\"music news\"\"|\"\"gram"
				+ "mys\"\"|\"\"grammy awards\"\"|\"\"2018 grammys\"\"|\"\"grammys 2018\"\"|\""
				+ "\"grammy awards 2018\"\"|\"\"2018 grammy awards\"\"|\"\"grammy nominations"
				+ "\"\"|\"\"jay z\"\"|\"\"jay-z\"\"|\"\"jayz\"\"|\"\"Childish Gambino\"\"|\""
				+ "\"childish\"\"|\"\"gambino\"\"|\"\"Kendrick Lamar\"\"|\"\"bruno mars\"\"|"
				+ "\"\"lorde\"\"|\"\"kendrick\"\"|\"\"lamar\"\"|\"\"Despacito\"\"|\"\"julia m"
				+ "ichaels\"\"|\"\"sza\"\"|\"\"khalid\"\"|\"\"Alessia Cara\"\"|\"\"lil uzi ve"
				+ "rt\"\"|\"\"4:44\"\"|\"\"damn.\"\"|\"\"kevan kenney\"\"|\"\"2017\"\"\"	3"
				+ "817	82	12									" };

		try (InputStreamReader streamReader = new InputStreamReader(
				new ByteArrayInputStream(Arrays.stream(vid)
						.collect(Collectors.joining(System.lineSeparator())).getBytes()));
				BufferedReader reader = new BufferedReader(streamReader)) {
			reader.readLine();
			videos = reader.lines().map(TrendingVideo::createTrendingVideo)
					.collect(Collectors.toList());

			explorer = new YoutubeTrendsExplorer(new ByteArrayInputStream(
					Arrays.stream(vid).collect(Collectors.joining(System.lineSeparator()))
							.getBytes()));
		} catch (IOException e) {
			throw new IllegalArgumentException("IOException", e);
		}
	}

	@Test
	public void testDatasetIsLoaded() {
		assertEquals(videos.size(), explorer.getTrendingVideos().size());
	}

	@Test
	public void testFindIdOfLeastLikedVideo() {
		String id = explorer.findIdOfLeastLikedVideo();
		assertEquals(LEAST_LIKED_VIDEO_ID, id);
	}

	@Test
	public void testFindIdOfMostLikedLeastDislikedVideo() {
		String id = explorer.findIdOfMostLikedLeastDislikedVideo();
		assertEquals(MOST_LIKED_LEAST_DISLIKED_VIDEO_ID, id);
	}

	@Test
	public void testFindDistinctTitlesOfTop3VideosByViews() {
		List<String> top3VideoTitles = explorer.findDistinctTitlesOfTop3VideosByViews();
		assertEquals(FIRST_TOP_VIDEO_TITLE, top3VideoTitles.get(0));
		assertEquals(SECOND_TOP_VIDEO_TITLE, top3VideoTitles.get(1));
		assertEquals(THIRD_TOP_VIDEO_TITLE, top3VideoTitles.get(2));
	}

	@Test
	public void testFindIdOfMostTaggedVideo() {
		String id = explorer.findIdOfMostTaggedVideo();
		assertEquals(MOST_TAGGED_VIDEO_ID, id);
	}

	@Test
	public void testFindTitleOfFirstVideoTrendingBefore100KViews() {
		String title = explorer.findTitleOfFirstVideoTrendingBefore100KViews();
		assertEquals(FIRST_BEFORE_100K_VIDEO_ID, title);
	}

	@Test
	public void testFindIdOfMostTrendingVideo() {
		String id = explorer.findIdOfMostTrendingVideo();
		assertEquals(MOST_TRENDING_VIDEO_ID, id);
	}
}
