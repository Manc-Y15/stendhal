package games.stendhal.server.entity.npc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import games.stendhal.server.core.engine.SingletonRepository;

import org.junit.Test;

import utilities.PlayerTestHelper;

public class NPCListTest {

	/**
	 * Tests for get.
	 */
	@Test
	public final void testGet() {
		final NPCList npclist = new NPCList() {
		};
		assertSame(npclist, SingletonRepository.getNPCList());
	}

	/**
	 * Tests for addHas.
	 */
	@Test
	public final void testAddHas() {
		PlayerTestHelper.generateNPCRPClasses();
		final NPCList npclist = new NPCList() {
		};
		npclist.add(new SpeakerNPC("Bob"));
		assertNotNull(npclist.get("Bob"));
		assertNotNull(npclist.get("BOB"));
	}

	/**
	 * Tests for remove.
	 */
	@Test
	public final void testRemove() {
		PlayerTestHelper.generateNPCRPClasses();
		final NPCList npclist = new NPCList() {
		};
		npclist.add(new SpeakerNPC("Bob"));
		assertNotNull(npclist.get("Bob"));
		assertNotNull(npclist.remove("Bob"));
		assertNull(npclist.get("Bob"));
		npclist.add(new SpeakerNPC("Bob"));
		assertNotNull(npclist.get("bob"));
		npclist.remove("BOB");
		assertNull(npclist.get("BOB"));
	}

	/**
	 * Tests for getNPCs.
	 */
	@Test
	public final void testGetNPCs() {
		PlayerTestHelper.generateNPCRPClasses();
		final NPCList npclist = new NPCList() {
		};
		final SpeakerNPC speakerNPC = new SpeakerNPC("Bob");
		npclist.add(speakerNPC);
		assertEquals(speakerNPC, npclist.get("Bob"));
		assertEquals(speakerNPC, npclist.get("BOB"));
	}

}
