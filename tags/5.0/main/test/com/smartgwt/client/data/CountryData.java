/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
package com.smartgwt.client.data;

import java.util.Date;

public class CountryData {

    private static CountryRecord[] records;

    public static CountryRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static CountryRecord[] getNewRecords() {
        return new CountryRecord[]{
                new CountryRecord("North America", "United States", "US", 9631420, 298444215, 12360, new Date(1776 - 1900, 6, 4), "federal republic", 2, "Washington, DC", true, "http://en.wikipedia.org/wiki/United_states", "Britain's American colonies broke with the mother country in 1776 and were recognized as the new nation of the United States of America following the Treaty of Paris in 1783. During the 19th and 20th centuries, 37 new states were added to the original 13 as the nation expanded across the North American continent and acquired a number of overseas possessions. The two most traumatic experiences in the nation's history were the Civil War (1861-65) and the Great Depression of the 1930s. Buoyed by victories in World Wars I and II and the end of the Cold War in 1991, the US remains the world's most powerful nation state. The economy is marked by steady growth, low unemployment and inflation, and rapid advances in technology."),
                new CountryRecord("Asia", "China", "CH", 9596960, 1313973713, 8859, null, "Communist state", 0, "Beijing", false, "http://en.wikipedia.org/wiki/China", "For centuries China stood as a leading civilization, outpacing the rest of the world in the arts and sciences, but in the 19th and early 20th centuries, the country was beset by civil unrest, major famines, military defeats, and foreign occupation. After World War II, the Communists under MAO Zedong established an autocratic socialist system that, while ensuring China's sovereignty, imposed strict controls over everyday life and cost the lives of tens of millions of people. After 1978, his successor DENG Xiaoping and other leaders focused on market-oriented economic development and by 2000 output had quadrupled. For much of the population, living standards have improved dramatically and the room for personal choice has expanded, yet political controls remain tight."),
                new CountryRecord("Asia", "Japan", "JA", 377835, 127463611, 4018, null, "constitutional monarchy with parliamentary government", 1, "Tokyo", true, "http://en.wikipedia.org/wiki/Japan", "In 1603, a Tokugawa shogunate (military dictatorship) ushered in a long period of isolation from foreign influence in order to secure its power. For 250 years this policy enabled Japan to enjoy stability and a flowering of its indigenous culture. Following the Treaty of Kanagawa with the US in 1854, Japan opened its ports and began to intensively modernize and industrialize. During the late 19th and early 20th centuries, Japan became a regional power that was able to defeat the forces of both China and Russia. It occupied Korea, Formosa (Taiwan), and southern Sakhalin Island. In 1931-32 Japan occupied Manchuria, and in 1937 it launched a full-scale invasion of China. Japan attacked US forces in 1941 - triggering America's entry into World War II - and soon occupied much of East and Southeast Asia. After its defeat in World War II, Japan recovered to become an economic power and a staunch ally of the US. While the emperor retains his throne as a symbol of national unity, actual power rests in networks of powerful politicians, bureaucrats, and business executives. The economy experienced a major slowdown starting in the 1990s following three decades of unprecedented growth, but Japan still remains a major economic power, both in Asia and globally. In 2005, Japan began a two-year term as a non-permanent member of the UN Security Council."),
                new CountryRecord("Asia", "India", "IN", 3287590, 1095351995, 3611, new Date(1947 - 1900, 7, 15), "federal republic", 2, "New Delhi", false, "http://en.wikipedia.org/wiki/India", "The Indus Valley civilization, one of the oldest in the world, dates back at least 5,000 years. Aryan tribes from the northwest infiltrated onto Indian lands about 1500 B.C.; their merger with the earlier Dravidian inhabitants created the classical Indian culture. Arab incursions starting in the 8th century and Turkish in the 12th were followed by those of European traders, beginning in the late 15th century. By the 19th century, Britain had assumed political control of virtually all Indian lands. Indian armed forces in the British army played a vital role in both World Wars. Nonviolent resistance to British colonialism led by Mohandas GANDHI and Jawaharlal NEHRU brought independence in 1947. The subcontinent was divided into the secular state of India and the smaller Muslim state of Pakistan. A third war between the two countries in 1971 resulted in East Pakistan becoming the separate nation of Bangladesh. Despite impressive gains in economic investment and output, India faces pressing problems such as the ongoing dispute with Pakistan over Kashmir, massive overpopulation, environmental degradation, extensive poverty, and ethnic and religious strife."),
                new CountryRecord("Europe", "Germany", "GM", 357021, 82422299, 2504, new Date(1871 - 1900, 0, 18), "federal republic", 2, "Berlin", true, "http://en.wikipedia.org/wiki/Germany", "As Europe's largest economy and second most populous nation, Germany remains a key member of the continent's economic, political, and defense organizations. European power struggles immersed Germany in two devastating World Wars in the first half of the 20th century and left the country occupied by the victorious Allied powers of the US, UK, France, and the Soviet Union in 1945. With the advent of the Cold War, two German states were formed in 1949: the western Federal Republic of Germany (FRG) and the eastern German Democratic Republic (GDR). The democratic FRG embedded itself in key Western economic and security organizations, the EC, which became the EU, and NATO, while the Communist GDR was on the front line of the Soviet-led Warsaw Pact. The decline of the USSR and the end of the Cold War allowed for German unification in 1990. Since then, Germany has expended considerable funds to bring Eastern productivity and wages up to Western standards. In January 1999, Germany and 10 other EU countries introduced a common European exchange currency, the euro."),
                new CountryRecord("Europe", "United Kingdom", "UK", 244820, 60609153, 1830, new Date(1801 - 1900, 0, 1), "constitutional monarchy", 1, "London", true, "http://en.wikipedia.org/wiki/United_kingdom", "Great Britain, the dominant industrial and maritime power of the 19th century, played a leading role in developing parliamentary democracy and in advancing literature and science. At its zenith, the British Empire stretched over one-fourth of the earth's surface. The first half of the 20th century saw the UK's strength seriously depleted in two World Wars. The second half witnessed the dismantling of the Empire and the UK rebuilding itself into a modern and prosperous European nation. As one of five permanent members of the UN Security Council, a founding member of NATO, and of the Commonwealth, the UK pursues a global approach to foreign policy; it currently is weighing the degree of its integration with continental Europe. A member of the EU, it chose to remain outside the Economic and Monetary Union for the time being. Constitutional reform is also a significant issue in the UK. The Scottish Parliament, the National Assembly for Wales, and the Northern Ireland Assembly were established in 1999, but the latter is suspended due to wrangling over the peace process."),
                new CountryRecord("Europe", "France", "FR", 547030, 60876136, 1816, null, "republic", 5, "Paris", true, "http://en.wikipedia.org/wiki/France", "Although ultimately a victor in World Wars I and II, France suffered extensive losses in its empire, wealth, manpower, and rank as a dominant nation-state. Nevertheless, France today is one of the most modern countries in the world and is a leader among European nations. Since 1958, it has constructed a presidential democracy resistant to the instabilities experienced in earlier parliamentary democracies. In recent years, its reconciliation and cooperation with Germany have proved central to the economic integration of Europe, including the introduction of a common exchange currency, the euro, in January 1999. At present, France is at the forefront of efforts to develop the EU's military capabilities to supplement progress toward an EU foreign policy."),
                new CountryRecord("Europe", "Italy", "IT", 301230, 58133509, 1698, new Date(1861 - 1900, 2, 17), "republic", 5, "Rome", true, "http://en.wikipedia.org/wiki/Italy", "Italy became a nation-state in 1861 when the regional states of the peninsula, along with Sardinia and Sicily, were united under King Victor EMMANUEL II. An era of parliamentary government came to a close in the early 1920s when Benito MUSSOLINI established a Fascist dictatorship. His disastrous alliance with Nazi Germany led to Italy's defeat in World War II. A democratic republic replaced the monarchy in 1946 and economic revival followed. Italy was a charter member of NATO and the European Economic Community (EEC). It has been at the forefront of European economic and political unification, joining the Economic and Monetary Union in 1999. Persistent problems include illegal immigration, organized crime, corruption, high unemployment, sluggish economic growth, and the low incomes and technical standards of southern Italy compared with the prosperous north."),
                new CountryRecord("Europe", "Russia", "RS", 17075200, 142893540, 1589, new Date(1991 - 1900, 7, 24), "federation", 3, "Moscow", true, "http://en.wikipedia.org/wiki/Russia", "Founded in the 12th century, the Principality of Muscovy, was able to emerge from over 200 years of Mongol domination (13th-15th centuries) and to gradually conquer and absorb surrounding principalities. In the early 17th century, a new Romanov Dynasty continued this policy of expansion across Siberia to the Pacific. Under PETER I (ruled 1682-1725), hegemony was extended to the Baltic Sea and the country was renamed the Russian Empire. During the 19th century, more territorial acquisitions were made in Europe and Asia. Repeated devastating defeats of the Russian army in World War I led to widespread rioting in the major cities of the Russian Empire and to the overthrow in 1917 of the imperial household. The Communists under Vladimir LENIN seized power soon after and formed the USSR. The brutal rule of Iosif STALIN (1928-53) strengthened communist rule and Russian dominance of the Soviet Union at a cost of tens of millions of lives. The Soviet economy and society stagnated in the following decades until General Secretary Mikhail GORBACHEV (1985-91) introduced glasnost (openness) and perestroika (restructuring) in an attempt to modernize Communism, but his initiatives inadvertently released forces that by December 1991 splintered the USSR into Russia and 14 other independent republics. Since then, Russia has struggled in its efforts to build a democratic political system and market economy to replace the strict social, political, and economic controls of the Communist period. While some progress has been made on the economic front, recent years have seen a recentralization of power under Vladimir PUTIN and the erosion of nascent democratic institutions. A determined guerrilla conflict still plagues Russia in Chechnya and threatens to destabilize the North Caucasus region."),
                new CountryRecord("South America", "Brazil", "BR", 8511965, 188078227, 1556, new Date(1822 - 1900, 8, 7), "federative republic", 3, "Brasilia", false, "http://en.wikipedia.org/wiki/Brazil", "Following three centuries under the rule of Portugal, Brazil became an independent nation in 1822 and a republic in 1889. By far the largest and most populous country in South America, Brazil overcame more than half a century of military intervention in the governance of the country when in 1985 the military regime peacefully ceded power to civilian rulers. Brazil continues to pursue industrial and agricultural growth and development of its interior. Exploiting vast natural resources and a large labor pool, it is today South America's leading economic power and a regional leader. Highly unequal income distribution remains a pressing problem."),
                new CountryRecord("North America", "Canada", "CA", 9984670, 33098932, 1114, new Date(1867 - 1900, 6, 1), "constitutional monarchy with parliamentary democracy and federation", 1, "Ottawa", true, "http://en.wikipedia.org/wiki/Canada", "A land of vast distances and rich natural resources, Canada became a self-governing dominion in 1867 while retaining ties to the British crown. Economically and technologically the nation has developed in parallel with the US, its neighbor to the south across an unfortified border. Canada's paramount political problem is meeting public demands for quality improvements in health care and education services after a decade of budget cuts. Canada also faces questions about integrity in government following revelations regarding a corruption scandal in the federal government that has helped revive the fortunes of separatists in predominantly francophone Quebec."),
                new CountryRecord("North America", "Mexico", "MX", 1972550, 107449525, 1067, new Date(1810 - 1900, 8, 16), "federal republic", 2, "Mexico (Distrito Federal)", false, "http://en.wikipedia.org/wiki/Mexico", "The site of advanced Amerindian civilizations, Mexico came under Spanish rule for three centuries before achieving independence early in the 19th century. A devaluation of the peso in late 1994 threw Mexico into economic turmoil, triggering the worst recession in over half a century. The nation continues to make an impressive recovery. Ongoing economic and social concerns include low real wages, underemployment for a large segment of the population, inequitable income distribution, and few advancement opportunities for the largely Amerindian population in the impoverished southern states. Elections held in July 2000 marked the first time since the 1910 Mexican Revolution that the opposition defeated the party in government, the Institutional Revolutionary Party (PRI). Vicente FOX of the National Action Party (PAN) was sworn in on 1 December 2000 as the first chief executive elected in free and fair elections."),
                new CountryRecord("Europe", "Spain", "SP", 504782, 40397842, 1029, new Date(1492 - 1900, 0, 1), "parliamentary monarchy", 4, "Madrid", false, "http://en.wikipedia.org/wiki/Spain", "Spain's powerful world empire of the 16th and 17th centuries ultimately yielded command of the seas to England. Subsequent failure to embrace the mercantile and industrial revolutions caused the country to fall behind Britain, France, and Germany in economic and political power. Spain remained neutral in World Wars I and II, but suffered through a devastating civil war (1936-39). A peaceful transition to democracy following the death of dictator Francisco FRANCO in 1975, and rapid economic modernization (Spain joined the EU in 1986), have given Spain one of the most dynamic economies in Europe and made it a global champion of freedom. Continuing challenges include Basque Fatherland and Liberty (ETA) terrorism and relatively high unemployment."),
                new CountryRecord("Asia", "South Korea", "KS", 98480, 48846823, 965.3, new Date(1945 - 1900, 7, 15), "republic", 5, "Seoul", false, "http://en.wikipedia.org/wiki/South_korea", "Korea was an independent kingdom for much of the past millennium. Following its victory in the Russo-Japanese War in 1905, Japan occupied Korea; five years later it formally annexed the entire peninsula. After World War II, a Republic of Korea (ROK) was set up in the southern half of the Korean Peninsula while a Communist-style government was installed in the north (the DPRK). During the Korean War (1950-53), US troops and UN forces fought alongside soldiers from the ROK to defend South Korea from DPRK attacks supported by China and the Soviet Union. An armistice was signed in 1953, splitting the peninsula along a demilitarized zone at about the 38th parallel. Thereafter, South Korea achieved rapid economic growth with per capita income rising to roughly 14 times the level of North Korea. In 1993, KIM Yo'ng-sam became South Korea's first civilian president following 32 years of military rule. South Korea today is a fully functioning modern democracy. In June 2000, a historic first North-South summit took place between the South's President KIM Tae-chung and the North's leader KIM Jong Il."),
                new CountryRecord("Asia", "Indonesia", "ID", 1919440, 245452739, 865.6, new Date(1945 - 1900, 7, 17), "republic", 5, "Jakarta", false, "http://en.wikipedia.org/wiki/Indonesia", "The Dutch began to colonize Indonesia in the early 17th century; the islands were occupied by Japan from 1942 to 1945. Indonesia declared its independence after Japan's surrender, but it required four years of intermittent negotiations, recurring hostilities, and UN mediation before the Netherlands agreed to relinquish its colony. Indonesia is the world's largest archipelagic state and home to the world's largest Muslim population. Current issues include: alleviating poverty, preventing terrorism, consolidating democracy after four decades of authoritarianism, implementing financial sector reforms, stemming corruption, and holding the military and police accountable for human rights violations. Indonesia was the nation worst hit by the December 2004 tsunami, which particularly affected Aceh province causing over 100,000 deaths and over $4 billion in damage. An additional earthquake in March 2005 created heavy destruction on the island of Nias. Reconstruction in these areas may take up to a decade. In 2005, Indonesia reached a historic peace agreement with armed separatists in Aceh, but it continues to face a low intensity separatist guerilla movement in Papua.")
        };
    }
}
