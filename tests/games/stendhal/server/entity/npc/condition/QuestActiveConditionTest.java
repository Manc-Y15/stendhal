package games.stendhal.server.entity.npc.condition;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import games.stendhal.server.entity.npc.parser.ConversationParser;
import games.stendhal.server.entity.player.Player;
import marauroa.common.Log4J;

import org.junit.BeforeClass;
import org.junit.Test;

import utilities.PlayerTestHelper;
import utilities.SpeakerNPCTestHelper;

public class QuestActiveConditionTest {
	@BeforeClass
	public static void setUpClass() throws Exception {
		Log4J.init();
	}

	/**
	 * Tests for fire.
	 */
	@Test
	public final void testFire() {
		assertThat(new QuestActiveCondition("questname").fire(
				PlayerTestHelper.createPlayer("player"),
				ConversationParser.parse("QuestActiveConditionTest"),
				SpeakerNPCTestHelper.createSpeakerNPC()),
				is(false));
		final Player bob = PlayerTestHelper.createPlayer("player");

		bob.setQuest("questname", "");
		assertThat(new QuestActiveCondition("questname").fire(bob,
				ConversationParser.parse("QuestActiveConditionTest"),
				SpeakerNPCTestHelper.createSpeakerNPC()),
				is(true));

		bob.setQuest("questname", null);
		assertThat(new QuestActiveCondition("questname").fire(bob,
				ConversationParser.parse("QuestActiveConditionTest"),
				SpeakerNPCTestHelper.createSpeakerNPC()),
				is(false));

		bob.setQuest("questname", "done");
		assertThat(new QuestActiveCondition("questname").fire(bob,
				ConversationParser.parse("QuestActiveConditionTest"),
				SpeakerNPCTestHelper.createSpeakerNPC()),
				is(false));
		
		bob.setQuest("questname", "rejected");
		assertThat(new QuestActiveCondition("questname").fire(bob,
				ConversationParser.parse("QuestActiveConditionTest"),
				SpeakerNPCTestHelper.createSpeakerNPC()),
				is(false));

	}

	/**
	 * Tests for questActiveCondition.
	 */
	@Test
	public final void testQuestActiveCondition() {
		new QuestActiveCondition("questname");
	}

	/**
	 * Tests for toString.
	 */
	@Test
	public final void testToString() {
		assertThat(new QuestActiveCondition("questname").toString(), is("QuestActive <questname>"));
	}

	/**
	 * Tests for equals.
	 */
	@Test
	public void testEquals() throws Throwable {
		assertThat(new QuestActiveCondition("questname"), not(equalTo(null)));

		final QuestActiveCondition obj = new QuestActiveCondition("questname");
		assertThat(obj, equalTo(obj));
		assertThat(new QuestActiveCondition("questname"), 
				equalTo(new QuestActiveCondition("questname")));

		assertThat(new QuestActiveCondition(null), 
				equalTo(new QuestActiveCondition(null)));

		assertThat(new QuestActiveCondition("questname"),
				not(equalTo(new Object())));

		assertThat(new QuestActiveCondition(null),
				not(equalTo(new QuestActiveCondition(
				"questname"))));
		assertThat(new QuestActiveCondition("questname"),
				not(equalTo(new QuestActiveCondition(
				null))));
		assertThat(new QuestActiveCondition("questname"),
				not(equalTo(new QuestActiveCondition(
				"questname2"))));

		assertThat(new QuestActiveCondition("questname"),
				equalTo((QuestActiveCondition) new QuestActiveCondition("questname") { 
					//sub classing
			}));
	}

	/**
	 * Tests for hashCode.
	 */
	@Test
	public void testHashCode() throws Exception {
		final QuestActiveCondition obj = new QuestActiveCondition("questname");
		assertThat(obj.hashCode(), equalTo(obj.hashCode()));
		assertThat(new QuestActiveCondition("questname").hashCode(),
				equalTo(new QuestActiveCondition("questname").hashCode()));
		assertThat(new QuestActiveCondition(null).hashCode(),
				equalTo(new QuestActiveCondition(null).hashCode()));

	}

}
