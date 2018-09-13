import java.util.Scanner;

public class Main {

    /**
     * Display the help message
     */
    private static void displayHelp(){
        System.out.println();
        System.out.println("Enter data to train or a prefix to guess the autocompletion of words");
        System.out.println("Commands: \\prefix: Exit training mode and enter prefix mode");
        System.out.println("          \\train: Exit prefix mode and enter training mode");
        System.out.println("          \\q or \\quit: Exit the program");
        System.out.println("          \\h or \\help: Display this message again");
        System.out.println();
    }

    /**
     * Run the REPL
     */
    public static void main(String[] args){
        AutoCompleteProviderImpl provider = new AutoCompleteProviderImpl();
        Scanner userInput = new Scanner(System.in);

        String input = "";
        boolean training = false;

        trainData(provider);

        displayHelp();
        do {
            if(training){
                System.out.print("Training data: ");
            }
            else{
                System.out.print("Enter prefix: ");
            }
            input = userInput.nextLine();

            if(input.equals("\\train")){
                if(!training)
                    System.out.println("\nEntering training mode\n");
                else
                    System.out.println("\nYou are already in training mode\n");
                training = true;
            }
            else if(input.equals("\\prefix")){
                if(training)
                    System.out.println("\nEntering prefix mode\n");
                else
                    System.out.println("\nYou are already in prefix mode\n");
                training = false;
            }
            else if(input.equals("\\h") || input.equals("\\help")){
                displayHelp();
            }
            else if(!input.equals("\\q") && !input.equals("\\quit")){
                if(training){
                    provider.train(input);
                }
                else{
                    System.out.println(provider.getWords(input));
                }
            }
            else{
                System.out.println("\nExiting");
            }
        } while(!input.equals("\\q") && !input.equals("\\quit"));
    }

    private static void trainData(AutoCompleteProvider provider){

        provider.train("Cornell University (/kɔːrˈnɛl/ kor-NEL) is a private and statutory Ivy League research university located in Ithaca, New York. Founded in 1865 by Ezra Cornell and Andrew Dickson White,[6] the university was intended to teach and make contributions in all fields of knowledge—from the classics to the sciences, and from the theoretical to the applied. These ideals, unconventional for the time, are captured in Cornell's motto, a popular 1865 Ezra Cornell quotation: \"I would found an institution where any person can find instruction in any study.\"[1]\n" +
                "\n" +
                "The university is broadly organized into seven undergraduate colleges and seven graduate divisions at its main Ithaca campus, with each college and division defining its own admission standards and academic programs in near autonomy. The university also administers two satellite medical campuses, one in New York City and one in Education City, Qatar, and Cornell Tech, a graduate program that incorporates technology, business, and creative thinking. The program moved from Google's Chelsea Building in New York City to its permanent campus on Roosevelt Island in September 2017.\n" +
                "\n" +
                "Cornell is one of three private land grant universities in the United States and the only one in New York.[note 1] Of its seven undergraduate colleges, three are state-supported statutory or contract colleges through the State University of New York (SUNY) system, including its agricultural and human ecology colleges as well as its industrial labor relations school. Of Cornell's graduate schools, only the veterinary college is state-supported. As a land grant college, Cornell operates a cooperative extension outreach program in every county of New York and receives annual funding from the State of New York for certain educational missions.[7] The Cornell University Ithaca Campus comprises 745 acres, but is much larger when the Cornell Botanic Gardens (more than 4,300 acres) and the numerous university-owned lands in New York City are considered.[8]\n" +
                "\n" +
                "As of 2017, 56 Nobel laureates, 4 Turing Award winners and 1 Fields Medalist have been affiliated with Cornell University. Since its founding, Cornell has been a co-educational, non-sectarian institution where admission has not been restricted by religion or race. Cornell counts more than 245,000 living alumni, and its former and present faculty and alumni include 34 Marshall Scholars, 30 Rhodes Scholars, 29 Truman Scholars, 7 Gates Scholars, and 14 living billionaires.[9][10][11] The student body consists of more than 14,000 undergraduate and 7,000 graduate students from all 50 American states and more than 120 countries");

        provider.train("Cornell University was founded on April 27, 1865; the New York State (NYS) Senate authorized the university as the state's land grant institution. Senator Ezra Cornell offered his farm in Ithaca, New York, as a site and $500,000 of his personal fortune as an initial endowment. Fellow senator and educator Andrew Dickson White agreed to be the first president. During the next three years, White oversaw the construction of the first two buildings and traveled to attract students and faculty.[14] The university was inaugurated on October 7, 1868, and 412 men were enrolled the next day.[15]\n" +
                "\n" +
                "Cornell's founders\n" +
                "\n" +
                "Ezra Cornell\n" +
                "\n" +
                "Andrew Dickson White\n" +
                "Cornell developed as a technologically innovative institution, applying its research to its own campus and to outreach efforts. For example, in 1883 it was one of the first university campuses to use electricity from a water-powered dynamo to light the grounds.[16] Since 1894, Cornell has included colleges that are state funded and fulfill statutory requirements;[17] it has also administered research and extension activities that have been jointly funded by state and federal matching programs.[18]\n" +
                "\n" +
                "Cornell has had active alumni since its earliest classes. It was one of the first universities to include alumni-elected representatives on its Board of Trustees.[note 2] Cornell was also among the Ivies that had heightened student activism during the 1960s related to cultural issues, civil rights, and opposition to the Vietnam War; with protests and occupations resulting in the resignation of Cornell's president and the restructuring of university governance.[19] Today the university has more than 4,000 courses.[20]\n" +
                "\n" +
                "Since 2000, Cornell has been expanding its international programs. In 2004, the university opened the Weill Cornell Medical College in Qatar.[21] It has partnerships with institutions in India, Singapore, and the People's Republic of China.[22][23][24] Former president Jeffrey S. Lehman described the university, with its high international profile, a \"transnational university\".[25] On March 9, 2004, Cornell and Stanford University laid the cornerstone for a new 'Bridging the Rift Center' to be built and jointly operated for education on the Israel–Jordan border.");

        provider.train("Ithaca campus\n" +
                "Main articles: Cornell Central Campus, Cornell North Campus, and Cornell West Campus\n" +
                "Cornell's main campus is on East Hill in Ithaca, New York, overlooking the city and Cayuga Lake. Since the university was founded, it has expanded to about 2,300 acres (9.3 km2), encompassing both the hill and much of the surrounding areas.[27] Central Campus has laboratories, administrative buildings, and almost all of the campus' academic buildings, athletic facilities, auditoriums, and museums. Collegetown contains two upper-class residence halls[28][29] and the Schwartz Performing Arts Center amid a mixed-use neighborhood of apartments, eateries, and businesses.[30]\n" +
                "\n" +
                "The main campus is marked by an irregular layout and eclectic architectural styles, including ornate Collegiate Gothic, Victorian, and Neoclassical buildings, and the more spare international and modernist structures. The more ornate buildings generally predate World War II. The student population doubled from 7,000 in 1950 to 15,000 by 1970, at a time when architectural styles favored modernism.[31] While some buildings are neatly arranged into quadrangles, others are packed densely and haphazardly. These eccentricities arose from the university's numerous, ever-changing master plans for the campus. For example, in one of the earliest plans, Frederick Law Olmsted, the designer of Central Park, proposed a \"grand terrace\" overlooking Cayuga Lake.[32]\n" +
                "\n" +
                "Several of the university buildings are listed on the National Register of Historic Places, including the Andrew Dickson White House, Bailey Hall, Caldwell Hall, Comstock Hall, Morrill Hall (Cornell University), and Deke House. At least three other historic buildings—the original Roberts Hall, East Robert Hall and Stone Hall—have also been listed on the NRHP. The university demolished them in the 1980s to make way for other development.[33] In September 2011, Travel+Leisure listed the Ithaca Campus as among the most beautiful in the United States.[34]\n" +
                "\n" +
                "Located among the rolling valleys of the Finger Lakes region, the campus on a hill provides views of the surrounding area, including 38 miles (61.4 km) long Cayuga Lake. Two gorges, Fall Creek Gorge and Cascadilla Gorge, bound Central Campus and are used as popular swimming holes during the warmer months (although the university and city code discourage their use).[35] Adjacent to the main campus, Cornell owns the 2,800 acre (11.6 km2) Cornell Botanic Gardens, a botanical garden containing flowers, trees, and ponds, with manicured trails providing access through the facility.[36]\n" +
                "\n" +
                "The university has embarked on numerous 'green' initiatives. In 2009, a new gas-fired combined heat and power facility replaced a coal-fired steam plant, resulting in a reduction in carbon emissions to 7% below 1990 levels, and projected to reduce carbon dioxide emissions by 75,000 tons per year.[37] This facility satisfies 15% of campus electrical needs,[38] and a university-run, on-campus hydroelectric plant in the Fall Creek Gorge provides an additional 2%.[39] The university has a lake source cooling project that uses Cayuga Lake to air condition campus buildings, with an 80% energy saving over conventional systems.[40] In 2007, Cornell established a Center for a Sustainable Future.[41] Cornell has been rated \"A-\" by the 2011 College Sustainability Report Card for its environmental and sustainability initiatives.[42]\n" +
                "\n" +
                "New York City campuses\n" +
                "Weill Cornell\n" +
                "Main article: Weill Cornell Medicine\n" +
                "\n" +
                "Weill Medical Center overlooks the East River in New York City.\n" +
                "Cornell's medical campus in New York, also called Weill Cornell, is on the Upper East Side of Manhattan, New York City. It is home to two Cornell divisions: Weill Cornell Medical College and Weill Cornell Graduate School of Medical Sciences, and has been affiliated with the NewYork–Presbyterian Hospital since 1927.[43] Although their faculty and academic divisions are separate, the Medical Center shares its administrative and teaching hospital functions with the Columbia University Medical Center.[44] These teaching hospitals include the Payne Whitney Clinic in Manhattan and the Westchester Division in White Plains, New York.[45] Weill Cornell Medical College is also affiliated with the neighboring Memorial Sloan–Kettering Cancer Center, Rockefeller University, and the Hospital for Special Surgery. Many faculty members have joint appointments at these institutions. Weill Cornell, Rockefeller, and Memorial Sloan–Kettering offer the Tri-Institutional MD–PhD Program to selected entering Cornell medical students.[46] From 1942 to 1979, the campus also housed the Cornell School of Nursing.[47]\n" +
                "\n" +
                "Cornell Tech\n" +
                "Main article: Cornell Tech\n" +
                "On December 19, 2011, Cornell University and Technion-Israel Institute of Technology won a competition for rights to claim free city land and $100 million in subsidies to build an engineering campus in New York City. The competition was established by New York City Mayor Michael Bloomberg in order to increase entrepreneurship and job growth in the city's technology sector. The winning bid consisted of a 2.1 million square feet state-of-the-art tech campus to be built on Roosevelt Island on the site of the former Coler-Goldwater Specialty Hospital. Instruction began in the fall of 2012 in a temporary location in Manhattan (111 Eighth Avenue in space donated by Google).[48] Thom Mayne of the architecture firm Morphosis has been selected to design the first building to be constructed on Roosevelt Island. Begun in 2014, construction of the first phase of the campus was completed in September 2017.[49]\n" +
                "\n" +
                "Other New York City programs\n" +
                "In addition to the tech campus and medical center, Cornell maintains local offices in New York City for some of its service programs. The Cornell Urban Scholars Program encourages students to pursue public service careers, arranging assignments with organizations working with New York City's poorest children, families, and communities.[50] The NYS College of Human Ecology and the NYS College of Agriculture and Life Sciences enable students to reach out to local communities by gardening and building with the Cornell Cooperative Extension.[51] Students with the NYS School of Industrial and Labor Relations' Extension & Outreach Program make workplace expertise available to organizations, union members, policymakers, and working adults.[52] The College of Engineering's Operations Research Manhattan, in the city's financial district, brings together business optimization research and decision support services addressed to both financial applications and public health logistics planning.[53] The College of Architecture, Art, and Planning has a 11,000 square foot Gensler-designed facility in 26 Broadway (The Standard Oil Building) in the Financial District that opened in 2015.[54]\n" +
                "\n" +
                "Qatar campus\n" +
                "\n" +
                "Weill Cornell Medical College in Qatar\n" +
                "Main article: Weill Cornell Medical College in Qatar\n" +
                "Weill Cornell Medical College in Qatar is in Education City, near Doha. Opened in September 2004, this is the first American medical school to be established outside the United States. The college is part of Cornell's program to increase its international influence. The college is a joint initiative with the Qatar government, which seeks to improve the country's academic programs and medical care.[21] Along with its full four-year MD program, which mirrors the curriculum taught at Weill Medical College in New York City, the college offers a two-year undergraduate pre-medical program with a separate admissions process. This undergraduate program opened in September 2002 and was the first coeducational institute of higher education in Qatar.[55]\n" +
                "\n" +
                "The college is partially funded by the Qatar government through the Qatar Foundation, which contributed $750 million for its construction.[56] The medical center is housed in a large two-story structure designed by Arata Isozaki, an internationally known Japanese architect.[57] In 2004, the Qatar Foundation announced the construction of a 350-bed Specialty Teaching Hospital near the medical college in Education City. The hospital was to be completed in a few years.[21]\n" +
                "\n" +
                "Other facilities\n" +
                "Cornell University owns and/or operates other facilities.[58] The Arecibo Observatory in Puerto Rico, site of the world's largest single-dish radio telescope, was operated by Cornell under a contract with the National Science Foundation from its construction until 2011.[59] The Shoals Marine Laboratory, operated in conjunction with the University of New Hampshire,[60] is a seasonal marine field station dedicated to undergraduate education and research on the 95-acre (0.4 km2) Appledore Island off the Maine–New Hampshire coast.[61]\n" +
                "\n" +
                "\n" +
                "A World War I Memorial on Cornell's West Campus in Ithaca\n" +
                "Cornell has facilities devoted to conservation and ecology. The New York State Agricultural Experiment Station, operated by the College of Agriculture and Life Sciences, is in Geneva, New York, 50 miles (80 km) northwest of the main campus. It operates three substations: The Cornell Lake Erie Research and Extension Laboratory (CLEREL) in Portland, New York,[62] Hudson Valley Laboratory in Highland,[63] and the Long Island Horticultural Research Laboratory in Riverhead.[64]\n" +
                "\n" +
                "\n" +
                "Cornell's Herbert F. Johnson Museum of Art, designed by I.M. Pei\n" +
                "The Cornell Lab of Ornithology in Ithaca's Sapsucker Woods performs research on biological diversity, primarily in birds.[65] On April 18, 2005, the lab announced that it had rediscovered the ivory-billed woodpecker, long thought to be extinct (Some experts disputed the evidence and subsequent surveys were inconclusive).[66] The Animal Science Teaching and Research Center in Harford, New York, and the Duck Research Laboratory in Eastport, New York, are resources for information on animal disease control and husbandry.[67][68]\n" +
                "\n" +
                "The Cornell Biological Field Station in Bridgeport, New York, conducts long-term ecological research and supports the university's educational programs, with special emphasis on freshwater lake systems.[69] The Department of Horticulture operates the Freeville Organic Research Farm and Homer C. Thompson Vegetable Research Farm in Freeville, New York.[9] The university operates biodiversity laboratories in Punta Cana, Dominican Republic,[70] and one in the Peruvian Amazon Rainforest (Cornell University Esbaran Amazon Field Laboratory).[71]\n" +
                "\n" +
                "The university arranges study abroad and scholarship programs. The Cornell in Washington is a program that allows students to study for a semester in Washington, D.C., holding research or internship positions while earning credit toward a degree.[72] Cornell in Rome, operated by the College of Architecture, Art, and Planning, allows students to use the city as a resource for learning architecture, urban studies, and art.[73] Similarly, the Capital Semester program allows students to intern in the New York state legislature in Albany.\n" +
                "\n" +
                "As New York State's land grant college, Cornell operates a cooperative extension service with 56 offices spread out across the state, each staffed with extension educators who offer programs in five subjects: Agriculture and Food Systems; Children, Youth, and Families; Community and Economic Vitality; Environment and Natural Resources; and Nutrition and Health.[74] Cornell also operates New York's Animal Health Diagnostic Center.[75]\n" +
                "\n" +
                "Organization and administration\n" +
                "College/school founding\n" +
                "College/school\t\n" +
                "Year founded\n" +
                "Agriculture and Life Sciences\t\n" +
                "1874\n" +
                "Architecture, Art, and Planning\t\n" +
                "1871\n" +
                "Arts and Sciences\t\n" +
                "1865\n" +
                "Business\t\n" +
                "1946\n" +
                "Engineering\t\n" +
                "1870\n" +
                "Graduate Studies\t\n" +
                "1909\n" +
                "Hotel Administration\t\n" +
                "1922\n" +
                "Human Ecology\t\n" +
                "1925\n" +
                "Industrial and Labor Relations\t\n" +
                "1945\n" +
                "Law\t\n" +
                "1887\n" +
                "Medical Sciences\t\n" +
                "1952\n" +
                "Medicine\t\n" +
                "1898\n" +
                "Tech\t\n" +
                "2011\n" +
                "Veterinary Medicine\t\n" +
                "1894\n" +
                "Cornell is a non-profit organization governed by a 64-member Board of Trustees consisting of both privately and publicly appointed trustees. Three trustees are appointed by the Governor of New York: one seat is reserved for the eldest lineal descendant of Ezra Cornell; two members from each of the fields of agriculture, business and labor in New York state; eight trustees to be elected from among and by the alumni of the university; two trustees to be elected from among and by the faculty of the university at Ithaca and Geneva; two trustees to be elected from among and by the membership of the university's student body at Ithaca (one undergraduate and one graduate student);[76] and one trustee to be elected from among and by the nonacademic staff and employees of the university at Ithaca and Geneva, 37 trustees at large and finally, the Governor, Temporary President of the Senate, Speaker of the Assembly, and president of the university serve in an ex officio voting capacity.[77][78] Robert Harrison has served as the chairman of the board since 2014.[79] The board elects a President to serve as the chief executive and educational officer.[77]\n" +
                "\n" +
                "Martha E. Pollack was inaugurated as Cornell's fourteenth president on August 25, 2017.[80][81] She succeeded Elizabeth Garrett, who served from July 2015 until her death from colon cancer on March 6, 2016 — the first Cornell president to die while in office.[82][83]\n" +
                "\n" +
                "The Board of Trustees hold four regular meetings each year, and portions of those meetings are subject to the New York State Open Meetings Law.[84]\n" +
                "\n" +
                "Cornell consists of nine privately endowed and four publicly supported \"statutory colleges\": the New York State College of Agriculture and Life Sciences, College of Human Ecology, School of Industrial and Labor Relations, and College of Veterinary Medicine. These statutory colleges received $131.9 million in SUNY appropriations in 2010-2011 to support their teaching, research, and service missions, which makes them accountable to SUNY trustees and other state agencies. The budget also includes $3.9 million of state funds for Cornell Cooperative Extension.[85][86][87] Residents of New York enrolled in these colleges also qualify for discounted tuition.[88] However, Attorney General Eliot Spitzer issued a 2005 opinion asserting that, with respect to their academic activities, statutory colleges should be understood to be private, non-state parties.[7]:1\n" +
                "\n" +
                "Cornell is decentralized, with its colleges and schools exercising wide autonomy. Each defines its own academic programs, operates its own admissions and advising programs, and confers its own degrees. The only university-wide requirements for a baccalaureate degree are to pass a swimming test, take two physical education courses, and satisfy a writing requirement. A handful of inter-school academic departments offer courses in more than one college.[89][90] All academic departments are affiliated with at least one college; the last department without such an affiliation, the Cornell Africana Studies and Research Center, merged with the Arts College in July 2011.[91]\n" +
                "\n" +
                "\n" +
                "The A.D. White Reading Room, which contains much of the 30,000 volume collection donated to the university by its co-founder and first president\n" +
                "Seven schools provide undergraduate programs and an additional seven provide graduate and professional programs. Students pursuing graduate degrees in departments of these schools are enrolled in the Graduate School. The School of Continuing Education and Summer Sessions offers programs for college and high school students, professionals, and other adults.[92] Of the 13,515 undergraduate students, 4,251 (31.5%) are affiliated with the largest college by enrollment, Arts and Sciences, followed by 3,153 (23.3%) in Agriculture and Life Sciences and 2,680 (19.8%) in Engineering. By student enrollment, the smallest of the seven undergraduate colleges is Architecture, Art, and Planning, with 515 (3.8%) students.[9]\n" +
                "\n" +
                "Several other universities have used Cornell as their model, including Stanford University, the University of Sydney in Australia, and the University of Birmingham in the United Kingdom; the last did so on the recommendation of one of its financiers, Andrew Carnegie, who was a Cornell Trustee.[93]\n" +
                "\n" +
                "The university also operates eCornell, which offers both certificate programs and professional development courses online.[94] In addition to being New York's land-grant college, Cornell is also a partner in New York's sea-grant program,[95] is the hub of the Northeast's sun-grant program,[96] and is a part of New York's space-grant consortium.[97]\n" +
                "\n" +
                "In 2015, Cornell ranked fifth among universities in the U.S. in fund-raising, collecting $591 million in private support.[98] In addition to the central University development staff located in Ithaca and New York City, each college and program has its own staffed fundraising program. In 2006, Cornell launched a $4 billion fundraising campaign, which reached $3 billion in November 2010.[99] In 2013, Cornell's \"Cornell Now\" fundraising campaign raised over $475 million.[100]\n" +
                "\n" +
                "Academics\n" +
                "\n" +
                "Sage Hall, home to the Samuel Curtis Johnson Graduate School of Management\n" +
                "Cornell is a large, primarily residential research university with a majority of enrollments in undergraduate programs.[101] The university has been accredited by the Middle States Commission on Higher Education since 1921.[102] Cornell operates on a 4–1–4 academic calendar with the fall term beginning in late August and ending in early December, a three-week winter session in January, and the spring term beginning in late January and ending in early May.[103]\n" +
                "\n" +
                "Cornell and Oregon State University are two of the three institutions, with the recent addition of Pennsylvania State University, which are members of the Land Grant, Sea Grant, Space Grant, and Sun Grant programs.\n" +
                "\n" +
                "Admissions\n" +
                "Admission to the university is highly competitive. For Fall 2018, Cornell received over 51,000 freshmen applications; 5,288 were admitted, a 10.3% acceptance rate.[104] For the Fall 2016 enrolled freshmen, the middle 50% range of SAT scores were 650-750 for critical reading, and 680-780 for math.[105] The middle 50% range of the ACT Composite score was 31-34.[105]\n" +
                "\n" +
                "Cornell enrolls students from all 50 U.S. states and more than 120 countries. As of Fall 2014, 25.7% of undergraduate students identified themselves as members of ethnic minority groups.[9] Legacy applicants receive a slight advantage in the admission process.[106]\n" +
                "\n" +
                "In 2013, the Samuel Curtis Johnson Graduate School of Management accepted 21% of its applicants for its two-year MBA program.[107]\n" +
                "\n" +
                "Financial aid\n" +
                "\n" +
                "The sarcophagus in Sage Chapel of Jennie McGraw, Cornell benefactress\n" +
                "Section 9 of the original charter of Cornell University ensured that the university \"shall be open to applicants for admission ... at the lowest rates of expense consistent with its welfare and efficiency, and without distinction as to rank, class, previous occupation or locality.\"[108] The University Charter provided for free instruction to one student chosen from each Assembly district in the state.[108]\n" +
                "\n" +
                "Starting in the 1950s Cornell coordinated with other Ivy League schools to provide a consistent set of financial aid. However, in 1989, a consent decree to end a Justice Department antitrust investigation ended such coordination.[109] Even after the decree, all Ivy League schools continue to award aid on financial need without offering any athletic scholarships.[110] In December 2010, Cornell announced a policy of matching any grant component of financial aid offers from other Ivy League schools, MIT, Duke University or Stanford, if an accepted applicant is trying to decide between Cornell and those other schools.[111]\n" +
                "\n" +
                "On January 31, 2008, Cornell announced a new financial aid initiative to be phased in over the following two years. In the first year, 2008–09, Cornell replaced need-based loans with scholarships for undergraduate students from families with incomes under $60,000 and capped such loans annually at $3,000 for students from families with incomes between $60,000 and $120,000. The following year, 2009–10, the program improved by replacing loan with scholarships for students from families with incomes up to $75,000, and capped annual loans at $3,000 for students from families with income between $75,000 and $120,000. For families above $120,000, need-based loans were capped at $7,500 per year.[112] The initiative costs an additional $14 million per year to fully implement.[113] Although Cornell's endowment dropped 27% in the second half of 2008, its President announced that the financial aid initiative will continue by withdrawing an additional $35 million from the endowment for undergraduate financial aid in 2009-10.[114] Cornell is seeking $125 million in gifts to support the financial aid initiative.[115] In 2010, 1,647 of the 3,181 full-time freshmen enrolled were found to have financial need (40%).[116] Of these, Cornell could meet the full financial aid needs of all 1,647 freshmen. Cornell's average undergraduate student's indebtedness at graduation is $21,549.[116]\n" +
                "\n" +
                "International programs\n" +
                "\n" +
                "Students performing a Raas, a traditional folk dance from India\n" +
                "Cornell offers undergraduate curricula with international focuses, including the Africana Studies, French Studies, German Studies, Jewish Studies, Latino Studies, Near Eastern Studies, Romance Studies, and Russian Literature majors.[9] In addition to traditional academic programs, Cornell students may study abroad on any of six continents.[117]\n" +
                "\n" +
                "The Asian Studies major, South Asia Program, South East Asia Program and China and Asia-Pacific Studies (CAPS) major provide opportunities for students and researchers in Asia. Cornell has an agreement with Peking University allowing students in the CAPS major to spend a semester in Beijing.[118] Similarly, the College of Engineering has an agreement to exchange faculty and graduate students with Tsinghua University in Beijing, and the School of Hotel Administration has a joint master's program with Nanyang Technological University in Singapore. The College of Agriculture and Life Sciences has signed an agreement with Japan's National Institute of Agrobiological Sciences,[119] and with the University of the Philippines, Los Baños,[120] to engage in joint research and exchange graduate students and faculty members. It also cooperates in agricultural research with the Indian Council of Agricultural Research.[121] Cornell also offers a course on International consulting in association with Indian Institute of Management Bangalore[122]\n" +
                "\n" +
                "In the Middle East, Cornell's efforts focus on biology and medicine. The Weill Cornell Medical College in Qatar trains new doctors to improve health services in the region.[123] The university is also developing the Bridging the Rift Center, a \"Library of Life\" (or database of all living systems) on the border of Israel and Jordan, in collaboration with those two countries and Stanford University.[124] Cornell has partnered with Queen's University in Canada to offer a joint Executive MBA. The innovative program includes both on-campus and videoconferencing-based, interactive virtual classroom sessions. Graduates of the program earn both a Cornell MBA and a Queen's MBA.[125]\n" +
                "\n" +
                "Cornell University is member of the United Nations Academic Impact aligning institutions of higher education to the United Nations and promoting international cooperation.\n" +
                "\n" +
                "Rankings\n" +
                "University rankings\n" +
                "National\n" +
                "ARWU[126]\t11\n" +
                "Forbes[127]\t15\n" +
                "U.S. News & World Report[128]\t14\n" +
                "Washington Monthly[129]\t27\n" +
                "Global\n" +
                "ARWU[130]\t13\n" +
                "QS[131]\t14\n" +
                "Times[132]\t19\n" +
                "U.S. News & World Report[133]\t23\n" +
                "In 2015, Cornell ranked 8th domestically and 10th internationally in the CWUR rankings.[134] Cornell ranked 14th in the 2018 edition of the QS World University Rankings and 19th in the 2017 edition of the Times Higher Education World University Rankings.[135][136] The university ranked 10th in the 2013 Business Insider Best Colleges in America ranking,[137] 15th in the 2016 U.S. News & World Report National Universities ranking,[138] and 13th globally in an academic ranking of world universities by Academic Ranking of World Universities in 2015, and 7th in the United States by the QS World University Rankings in 2018.[139] Cornell was ranked 27th nationally in The Washington Monthly's 2016 ranking of universities' contributions to research, community service, and social mobility.[140] In 2017, the university was ranked 7th in The Princeton Review's \"Top 50 Green Colleges\".[141]\n" +
                "\n" +
                "\n" +
                "Cornell's 2008 commencement ceremony at Schoellkopf Field\n" +
                "In its annual edition of \"America's Best Architecture & Design Schools\", the journal Design Intelligence has consistently ranked Cornell's Bachelor of Architecture program as number one in the nation (2000–2002, 2005–2007, 2009–2013 and 2015-2016). In the 2011 survey, the program ranked first and the Master of Architecture program ranked sixth.[142] In 2017, Design Intelligence ranked Cornell's Master of Landscape Architecture program 4th in the nation with the Bachelor of Science in Landscape Architecture program ranking 5th among its undergraduate counterparts.[143][144] Among business schools in the United States, the Johnson School of Management at Cornell was named the No. 10 business school by Forbes in 2015,[145] 8th by The Washington Post for salary potential, 14th overall by Poets and Quants[146] but ranked 4th for Investment Banking[147] and 6th for salary,[148] 16th by Bloomberg Businessweek in 2015,[149] and 15th by The Economist in 2015.[149] The Johnson school was ranked No. 2 by Bloomberg Businessweek.[150]\n" +
                "\n" +
                "Cornell's international relations offerings are also ranked in Foreign Policy magazine's Inside the Ivory Tower survey, which lists the world's top twenty of such programs at the undergraduate, Master's and Ph.D. levels.[151] In 2012, the survey ranked Cornell 11th overall for doctoral programs and 12th overall in the undergraduate category.[152] In 2015, Cornell University was ranked 3rd in New York State by average professor salaries.[153]\n" +
                "\n" +
                "Library\n" +
                "\n" +
                "The Cornell Law Library is one of 12 national depositories for print records of briefs filed with the U.S. Supreme Court.\n" +
                "Main article: Cornell University Library\n" +
                "The Cornell University Library is the 11th largest academic library in the United States, ranked by number of volumes held.[154] Organized into 20 divisions, in 2005 it held 7.5 million printed volumes in open stacks, 8.2 million microfilms and microfiches, and a total of 440,000 maps, motion pictures, DVDs, sound recordings, and computer files in its collections, in addition to extensive digital resources and the University Archives.[155] It was the first among all U.S. colleges and universities to allow undergraduates to borrow books from its libraries.[9] In 2006, The Princeton Review ranked it as the 11th best college library,[156] and it climbed to 6th best in 2009.[157] The library plays an active role in furthering online archiving of scientific and historical documents. arXiv, an e-print archive created at Los Alamos National Laboratory by Paul Ginsparg, is operated and primarily funded by Cornell as part of the library's services. The archive has changed the way many physicists and mathematicians communicate, making the e-print a viable and popular means of announcing new research.[158]\n" +
                "\n" +
                "Press and scholarly publications\n" +
                "Main article: Cornell University Press\n" +
                "The Cornell University Press, established in 1869 but inactive from 1884 to 1930, was the first university publishing enterprise in the United States.[159][160] Today, the press is one of the country's largest university presses.[9] It produces approximately 150 nonfiction titles each year in various disciplines including anthropology, Asian studies, biological sciences, classics, history, industrial relations, literary criticism and theory, natural history, politics and international relations, veterinary science, and women's studies.[160][161]\n" +
                "\n" +
                "Cornell's academic units and student groups also publish a number of scholarly journals. Faculty-led publications include the Johnson School's Administrative Science Quarterly,[162] the ILR School's Industrial and Labor Relations Review, the Arts and Sciences Philosophy Department's The Philosophical Review, the College of Architecture, Art, and Planning's Journal of Architecture, and the Law School's Journal of Empirical Legal Studies.[163] Student-led scholarly publications include the Law Review, the Cornell Institute for Public Affairs' Cornell Policy Review, the International Law Journal, the Journal of Law and Public Policy, the International Affairs Review, and the HR Review. Physical Review, recognized internationally as among the best and well known journals of physics, was founded at Cornell in 1893 before being later managed by the American Physical Society.\n" +
                "\n" +
                "Research\n" +
                "\n" +
                "Cornell's Center for Advanced Computing was one of the five original centers of the NSF's Supercomputer Centers Program.\n" +
                "\n" +
                "Cornell Botanic Gardens, located adjacent to the Ithaca campus, is used for conservation research and for recreation by Cornellians\n" +
                "\n" +
                "In the basement of Goldwin Smith Hall, researchers in the Dendrochronology Lab determine the age of archaeological artifacts found at digs\n" +
                "Cornell, a research university, is ranked fourth in the world in producing the largest number of graduates who go on to pursue PhDs in engineering or the natural sciences at American institutions, and fifth in the world in producing graduates who pursue PhDs at American institutions in any field.[164] Research is a central element of the university's mission; in 2009 Cornell spent $671 million on science and engineering research and development, the 16th highest in the United States.[165]\n" +
                "\n" +
                "For the 2004–05 fiscal year, the university spent $561.3 million on research.[166] The primary recipients of this funding were the colleges of Medicine ($164.2 million), Agriculture and Life Sciences ($114.5 million), Arts and Sciences ($80.3 million), and Engineering ($64.8 million).[166] The money comes largely from federal sources, with federal investment of $381.0 million. The federal agencies that invest the most money are the Department of Health and Human Services and the National Science Foundation that make up, respectively, 51.4% and 30.7% of all federal investment in the university.[166] Cornell was on the top-ten list of U.S. universities receiving the most patents in 2003, and was one of the nation's top five institutions in forming start-up companies.[167] In 2004–05, Cornell received 200 invention disclosures, filed 203 U.S. patent applications, completed 77 commercial license agreements, and distributed royalties of more than $4.1 million to Cornell units and inventors.[9]\n" +
                "\n" +
                "Since 1962, Cornell has been involved in unmanned missions to Mars.[168] In the 21st century, Cornell had a hand in the Mars Exploration Rover Mission. Cornell's Steve Squyres, Principal Investigator for the Athena Science Payload, led the selection of the landing zones and requested data collection features for the Spirit and Opportunity rovers.[169] Jet Propulsion Laboratory engineers took those requests and designed the rovers to meet them. The rovers, both of which have operated long past their original life expectancies, are responsible for the discoveries that were awarded 2004 Breakthrough of the Year honors by Science.[170] Control of the Mars rovers has shifted between NASA's Jet Propulsion Laboratory at Caltech and Cornell's Space Sciences Building.[171] Further, Cornell researchers discovered the rings around the planet Uranus,[172] and Cornell built and operated the telescope at Arecibo Observatory located in Arecibo, Puerto Rico until 2011, when they transferred the operations to SRI International, the Universities Space Research Association and the Metropolitan University of Puerto Rico.[173]\n" +
                "\n" +
                "The Automotive Crash Injury Research Project was begun in 1952.[174] It pioneered the use of crash testing, originally using corpses rather than dummies. The project discovered that improved door locks, energy-absorbing steering wheels, padded dashboards, and seat belts could prevent an extraordinary percentage of injuries.[174]\n" +
                "\n" +
                "In the early 1980s, Cornell deployed the first IBM 3090-400VF and coupled two IBM 3090-600E systems to investigate coarse-grained parallel computing. In 1984, the National Science Foundation began work on establishing five new supercomputer centers, including the Cornell Center for Advanced Computing, to provide high-speed computing resources for research within the United States. As an NSF center, Cornell deployed the first IBM Scalable Parallel supercomputer. In the 1990s, Cornell developed scheduling software and deployed the first supercomputer built by Dell. Most recently, Cornell deployed Red Cloud, one of the first cloud computing services designed specifically for research. Today, the center is a partner on the National Science Foundation XSEDE supercomputing program, providing coordination for XSEDE architecture and design, systems reliability testing, and online training using the Cornell Virtual Workshop learning platform.[175]\n" +
                "\n" +
                "Cornell scientists have researched the fundamental particles of nature for more than 70 years. Cornell physicists, such as Hans Bethe, contributed not only to the foundations of nuclear physics but also participated in the Manhattan Project (see also: List of Cornell Manhattan Project people). In the 1930s, Cornell built the second cyclotron in the United States. In the 1950s, Cornell physicists became the first to study synchrotron radiation. During the 1990s, the Cornell Electron Storage Ring, located beneath Alumni Field, was the world's highest-luminosity electron-positron collider.[176][177] After building the synchrotron at Cornell, Robert R. Wilson took a leave of absence to become the founding director of Fermilab, which involved designing and building the largest accelerator in the United States.[178] Cornell's accelerator and high-energy physics groups are involved in the design of the proposed International Linear Collider and plan to participate in its construction and operation. The International Linear Collider, to be completed in the late 2010s, will complement the Large Hadron Collider and shed light on questions such as the identity of dark matter and the existence of extra dimensions.[179]\n" +
                "\n" +
                "In the area of humanities and social sciences, Cornell is best known for being one of the world's greatest centers for the study of Southeast Asia. The Southeast Asia Program (SEAP) at Cornell is designated as a National Resource Center (NRC) by the United States Department of Education 2010–2014. Therefore, the SEAP is nationally prominent in promoting advanced foreign language training, area and international knowledge in the liberal arts and applied discipline focused on Southeast Asia.[180] The George McTurnan Kahin Center for Advanced Research on Southeast Asia is located in the historic \"Treman House.\"[181] The house was built by Robert Henry Treman, the son of an enterprising local family and the first member of that family to attend Cornell University and be elected to its board of trustees. The George McTurnan Kahin Center is home to SEAP graduate students, visiting fellows and scholars, faculty members, and SEAP's Publication and Outreach offices.[182]\n" +
                "\n" +
                "As part of its research work, Cornell has established a number of research collaborations with universities around the globe. Foe example, a partnership with the University of Sussex (including the Institute of Development Studies at Sussex) allows research and teaching collaboration between the two institutions.[183]\n" +
                "\n" +
                "Student life\n" +
                "Activities\n" +
                "\n" +
                "Interior windows of Barton Hall, an on-campus field house\n" +
                "\n" +
                "The Fuertes Observatory on Cornell's North Campus is open to the public every Friday night\n" +
                "For the 2016-17 academic year, Cornell had over 1,000 registered student organizations. These clubs and organizations run the gamut from kayaking to full-armor jousting, from varsity and club sports and a cappella groups to improvisational theatre, from political clubs and publications to chess and video game clubs.[184] The Cornell International Affairs Society sends over 100 Cornellians to collegiate Model United Nations conferences across North America and hosts the Cornell Model United Nations Conference each spring for over 500 high school students. Additionally, the Cornell International Affairs Society's traveling Model United Nations team is ranked number 16 in the nation.[185] Cornell United Religious Work is a collaboration among many diverse religious traditions, helping to provide spiritual resources throughout a student's time at college. The Cornell Catholic Community is the largest Catholic student organization on campus. Student organizations also include a myriad of groups including a symphony orchestra,[186] concert bands,[187] formal and informal choral groups,[188] including the Sherwoods and Cayuga's Waiters (a pun on the first line of the alma mater, \"Far above Cayuga's waters . . . \") and other musical groups that play everything from classical, jazz, to ethnic styles in addition to the Big Red Marching Band, which performs regularly at football games and other campus events.[189] Organized in 1868, the oldest Cornell student organization is the Cornell University Glee Club.[190] A Cornell student organization, The Cornell Astronomical Society, runs public observing nights every Friday evening at the Fuertes Observatory. The university is home to the Telluride House, an intellectual residential society. The university is also home to three secret honor societies called Sphinx Head,[191] Der Hexenkreis and Quill and Dagger[192][193] that have maintained a presence on campus for well over 120 years.\n" +
                "\n" +
                "Cornell's clubs are primarily subsidized financially by the Student Assembly and the Graduate & Professional Student Assembly, two student-run organizations with a collective budget of $3.0 million per year.[194][195] The assemblies also finance other student life programs including a concert commission and an on-campus theater.\n" +
                "\n" +
                "Greek life, professional, and honor societies\n" +
                "Main article: List of fraternities and sororities at Cornell University\n" +
                "Cornell hosts a large fraternity and sorority system, with 70 chapters involving 33% of male and 24% of female undergraduates.[196][197][198] Alpha Phi Alpha, the first intercollegiate Greek-letter organization established for African Americans, was founded at Cornell in 1906.[199][200] Alpha Zeta fraternity, the first Greek-lettered organization established for Latin Americans in the United States, was also founded at Cornell on January 1, 1890. Alpha Zeta served the wealthy international Latin American students that came to the United States to study. This organization led a movement of fraternities that catered to international Latin American students that was active from 1890 to 1975.[201] On February 19, 1982, La Unidad Latina, Lambda Upsilon Lambda fraternity was established;[202] it would eventually become the only Latino based fraternity in the nation with chapters at every Ivy League institution.[203] Latinas Promoviendo Comunidad/Lambda Pi Chi sorority was established on April 16, 1988, making the organization the first Latina-Based, and not Latina exclusive, sorority founded at an ivy-league institution.[204]\n" +
                "\n" +
                "Cornell's connection to national Greek life is strong and longstanding. Many chapters are among the oldest of their respective national organizations, as evidenced by the proliferation of Alpha-series chapters. The chapter house of Alpha Delta Phi constructed in 1877 is believed to be the first house built in America solely for fraternity use, and the chapter's current home was designed by John Russell Pope.[205] Philanthropy opportunities are used to encourage community relations, for example, during the 2004–05 academic year, the Greek system contributed 21,668 community service and advocacy hours and raised $176,547 in charitable contributions from its philanthropic efforts.[197] Generally, discipline is managed internally by the inter-Greek governing boards. As with all student, faculty or staff misconduct, more serious cases are reviewed by the Judicial Administrator, who administers Cornell's justice system.[197]\n" +
                "\n" +
                "Press and radio\n" +
                "The Cornell student body produces several works by way of print and radio. Student-run newspapers include The Cornell Daily Sun, an independent daily; The Cornell Review, a conservative newspaper published fortnightly; and The Cornell Progressive (newspaper), a liberal newspaper published every month.\n" +
                "\n" +
                "Other press outlets include The Cornell Lunatic, a campus humor magazine; the Cornell Chronicle, the university's newspaper of record; and Kitsch Magazine, a feature magazine published in cooperation with Ithaca College. The Cornellian is an independent student organization that organizes, arranges, produces, edits, and publishes the yearbook of the same name; it is composed of artistic photos of the campus, student life, and athletics, and of the standard senior portraits. It carries the Silver Crown Award for Journalism and a Benjamin Franklin Award for Print Design – the only Ivy League Yearbook with such a distinction.[206] Cornellians are represented over the radio waves on WVBR, an independent commercial FM radio station owned and operated by Cornell students. Other student groups also operate internet streaming audio sites.[207]\n" +
                "\n" +
                "Housing\n" +
                "\n" +
                "One of several footbridges that span Cornell's gorges and ease commuting from housing to academic buildings on campus\n" +
                "University housing is broadly divided into three sections: North Campus, West Campus, and Collegetown. Cornell University began experiments with co-ed dormitories in 1971, and continued the tradition of residential advisors (RAs) within the campus system. In 1991, new students could be found throughout West Campus, including at the historic Baker and Boldt Hall complexes; since a 1997 residential initiative, West Campus houses transfer and returning students, whereas North Campus is almost entirely populated by freshmen.[208]\n" +
                "\n" +
                "The options for living on North Campus for upperclassmen are the program houses and co-op houses: Risley Residential College, Just About Music, the Ecology House, Holland International Living Center, the Multicultural Living Learning Unit, the Latino Living Center, Akwe:kon, and Ujamaa. In an attempt to create a sense of community and an atmosphere of education outside the classroom and continue Andrew Dickson White's vision, a $250 million reconstruction of West Campus created residential colleges there for undergraduates.[209] The idea of building a house system can be attributed in part to the success of Risley Residential College, the oldest continually operating residential college at Cornell.[210]\n" +
                "\n" +
                "Additionally, Cornell has several housing areas for graduate and professional students. Of these, Schuyler House (which was formerly a part of Sage Infirmary)[211] has a dorm layout, while Maplewood Apartments, Hasbrouck Apartments, and Thurston Court Apartments are apartment-style, some even allowing for family living. Off campus, many single-family houses in the East Hill neighborhoods adjacent to the university have been converted to apartments. Private developers have also built several multi-story apartment complexes in the Collegetown neighborhood. Nine percent of undergraduate students reside in fraternity and sorority houses, although first semester freshmen are not permitted to join them.[212] Cornell's Greek system has 67 chapters and over 54 Greek residences that house approximately 1,500 students. About 42% of Greek members live in their houses.[213] Housing cooperatives or other independent living units exist, including Watermargin, Telluride House, Triphammer Cooperative, the Center for Jewish Living, the Wait Cooperative, Von Cramm Cooperative Hall, Phillips House (located on North Campus, 1975 all women; 2016, all men), Center for World Community (international community, off campus, formed by Annabel Taylor Hall, 1972, mixed gender), and Cayuga Lodge.[214] Besides this, there exists also cooperative housing not owned by Cornell, like Gamma Alpha or Stewart Little.\n" +
                "\n" +
                "As of 2014, Cornell's dining system was ranked 3rd in the nation by the Princeton Review.[215] The university has 29 on-campus dining locations, including 10 \"All You Care to Eat\" cafeterias.[216] North Campus is home to 3 of these dining halls: Robert Purcell Marketplace Eatery (located in Robert Purcell Community Center), North Star Dining Room (located in the Appel Commons), and Risley Dining (located in Risley Hall).[216] West Campus houses 6 dining halls, 5 of which accompany the West Campus residential houses: Cook House Dining Room, Becker House Dining Room, Rose House Dining Room, Jansen's Dining Room at Hans Bethe House, and Keeton House Dining Room.[216] Also located on West Campus is 104West!, a kosher/multicultural dining room.[216] Central Campus accommodates just a single dining hall: Okenshields, located in Willard Straight Hall.[216]\n" +
                "\n" +
                "Various Cornell housing facilities\n" +
                "\n" +
                "Baker Dormitories\n" +
                "\n" +
                "Balch Hall\n" +
                "\n" +
                "Hans Bethe House\n" +
                "\n" +
                "Risley Hall\n" +
                "Athletics\n" +
                "\n" +
                "A 1908 print depicting a Cornell baseball player\n" +
                "Main article: Cornell Big Red\n" +
                "Cornell has 36 varsity intercollegiate teams that have the nickname of the Big Red. An NCAA Division I institution, Cornell is a member of the Ivy League and ECAC Hockey and competes in the Eastern College Athletic Conference (ECAC), the largest athletic conference in North America.[217] (ECAC Hockey is no longer affiliated with the ECAC.) Cornell's varsity athletic teams consistently challenge for NCAA Division I titles in a number of sports, including men's wrestling, men's lacrosse, men's ice hockey, and rowing (the women's crew program is subject to the NCAA, while the men's rowing program is governed by its own administrative body, the Intercollegiate Rowing Association). Under the Ivy League athletic agreement, the university does not offer athletic scholarships for athletic recruiting.[218]\n" +
                "\n" +
                "Cornell University's football team had at least a share of the national championship four times before 1940[219][220] and has won the Ivy League championship three times, last in 1990.[221]\n" +
                "\n" +
                "In 2010, the Cornell men's basketball team appeared for the first time in the NCAA tournament's East Regional Semifinals, known as the \"Sweet 16.\" It was the first Ivy League team to make the semifinals since 1979.[222]\n" +
                "\n" +
                "Cornell Outdoor Education\n" +
                "Cornell University runs one of the largest collegiate outdoor education programs in the country, serving over 20,000 people every year. The program runs over 130 different courses including but not limited to: Backpacking and Camping, Mountain Biking, Bike Touring, Caving, Hiking, Rock and Ice Climbing, Wilderness First Aid, and tree climbing.[223] COE also runs one of the largest pre-freshman summer programs known as Outdoor Odyssey.[224] Most classes are often entirely taught by paid student instructors and courses count toward Cornell's physical education graduation requirement.[225]\n" +
                "\n" +
                "One of the most remarkable facilities at Cornell Outdoor Education is The Lindseth Climbing Wall. The wall is the largest indoor natural rock climbing wall in North America, covering the entire east end of Bartels Hall, and is 160' wide and 30' high, for a total of 4,800 square feet of climbing surface.[226] Over the past year, COE has been extensively fundraising to fully upgrade and modernize the wall.[227]\n" +
                "\n" +
                "Cornelliana\n" +
                "\n" +
                "A tradition started in 1901, Dragon Day celebrates a feat by first-year architecture students to construct a colossal dragon to be paraded to center campus and then burned.\n" +
                "\n" +
                "An ivy-covered emblem of Ezra Cornell circumscribed by the university motto\n" +
                "Main article: Cornelliana\n" +
                "Cornelliana is a term for Cornell's traditions, legends, and lore. Cornellian traditions include Slope Day, a celebration held on the last day of classes of the spring semester, and Dragon Day, which includes the burning of a dragon built by architecture students. Dragon Day is one of the school's oldest traditions and has been celebrated annually since 1901, typically on or near St. Patrick's Day. The dragon is built secretly by the architecture students, and taunting messages are left for the engineering students for the week before Dragon Day. On Dragon Day, the dragon is paraded across the Arts Quad and then set afire.[228]\n" +
                "\n" +
                "According to legend, if a virgin crosses the Arts Quad at midnight, the statues of Ezra Cornell and Andrew Dickson White will walk off their pedestals, meet in the center of the Quad, and shake hands, congratulating themselves on the chastity of students. There is also another myth that if a couple crosses the suspension bridge on North Campus, and the young woman does not accept a kiss from her partner, the bridge will fall. If the kiss is accepted, the couple is assured a long future together.[229]\n" +
                "\n" +
                "The university is also host to various student pranks. For example, on at least two different occasions the university has awoken to find something odd atop the 173-foot (52.7 m) tall McGraw clock tower—once a 60-pound (27 kg) pumpkin and another time a disco ball. Because there is no access to the spire atop the tower, how the items were put in place remains a mystery.[230] The colors of the lights on McGraw tower change to orange for Halloween and green for St. Patrick's Day.[231] The clock tower also plays music.\n" +
                "\n" +
                "The school colors are carnelian (a shade of red) and white, a play on \"Cornellian\" and Andrew Dickson White. A bear is commonly used as the unofficial mascot, which dates back to the introduction of the mascot \"Touchdown\" in 1915, a live bear who was brought onto the field during football games.[5] The university's alma mater is \"Far Above Cayuga's Waters\", and its fight song is \"Give My Regards to Davy\". People associated with the university are called \"Cornellians\".\n" +
                "\n" +
                "Health\n" +
                "Cornell offers a variety of professional and peer counseling services to students.[232] Formerly called Gannett Health Services until its name change in 2016, Cornell Health offers on-campus outpatient health services with emergency services and residential treatment provided by Cayuga Medical Center.[233] For most of its history, Cornell provided residential medical care for sick students, including at the historic Sage Infirmary.[234] Cornell offers specialized reproductive health and family planning services.[235] The university also has a student-run Emergency Medical Service (EMS) agency. The squad provides emergency response to medical emergencies on Cornell University campus and surrounding university-owned properties. Cornell EMS also provides stand-by service for university events and provides CPR, First Aid and other training seminars to the Cornell community.[236]\n" +
                "\n" +
                "The university received worldwide attention for a series of six student suicides by jumping into a gorge that occurred during the 2009–10 school year, and after the incidents added temporary fences to the bridges which span area gorges.[237] In May 2013, Cornell indicated that it planned to set up nets, which will extend out 15 feet, on five of the university's bridge.[238] Installation of the nets began in May 2013 and were completed over the summer of that year.[237] There were cases of gorge-jumping in the 1970s and 1990s.[239] Before this abnormal cluster of suicides, the suicide rate at Cornell had been similar to or below the suicide rates of other American universities, including a period between 2005 and 2008 in which no suicides occurred.[240][241]\n" +
                "\n" +
                "Campus police\n" +
                "Cornell University Police protect the campus and are classified as peace officers and have the same authority as the Ithaca city police. They are similar to the campus police at Ithaca College and Syracuse University because those campus police are classified as armed peace officers. The Cornell University Police are on campus and on call 24 hours a day, 365 days a year. Their duties include: patrolling the university around the clock, responding to emergency situations and to non-emergency calls for service, crime prevention services, active investigation of crimes on campus, enforcement of state criminal and motor vehicle laws, and campus regulations.[242][non-primary source needed]\n" +
                "\n" +
                "People\n" +
                "See also: List of Nobel laureates affiliated with Cornell University\n" +
                "Cornell counts numerous notable individuals who have either come to the university as faculty to teach and to conduct research, or as students who have gone on to do noteworthy things. In total, 56 Nobel laureates were either faculty or students at Cornell.[10]\n" +
                "\n" +
                "Faculty\n" +
                "\n" +
                "1916 Cornell faculty\n" +
                "Main article: List of Cornell University faculty\n" +
                "As of 2009, Cornell had 1,639 full-and part-time faculty members affiliated with its main campus,[9] 1,235 affiliated with its New York City divisions, and 34 affiliated with its campus in Qatar.[9] Cornell's faculty for the 2005–06 academic year included three Nobel laureates, a Crafoord Prize winner, two Turing Award winners, a Fields Medal winner, two Legion of Honor recipients, a World Food Prize winner, an Andrei Sakharov Prize winner, three National Medal of Science winners, two Wolf Prize winners, five MacArthur award winners, four Pulitzer Prize winners, a Carter G. Woodson Scholars Medallion recipient, 20 National Science Foundation career grant holders, a recipient of the National Academy of Sciences Award, a recipient of the American Mathematical Society's Steele Prize for Lifetime Achievement, a recipient of the Heineman Prize for Mathematical Physics, and three Packard Foundation grant holders.[9]\n" +
                "\n" +
                "Kurt Lewin taught at Cornell from 1933 to 1935 and is considered the \"father of social psychology\".[243] Norman Borlaug taught at the university from 1982 to 1988 and is considered the \"father of the Green Revolution\",[244] being awarded the Nobel Peace Prize, the Presidential Medal of Freedom, the Congressional Gold Medal, and 49 honorary doctorates.[245] Frances Perkins joined the Cornell faculty in 1952 after serving as the first female member of the United States Cabinet and served until her death in 1965. Perkins was a witness to the Triangle Shirtwaist Factory fire in her adolescence and went on to champion the National Labor Relations Act, the Fair Labor Standards Act, and the Social Security Act while United States Secretary of Labor. Buckminster Fuller was a visiting professor at Cornell for one year (1952),[246] and Henry Louis Gates, African American Studies scholar and subject of an arrest controversy and White House \"Beer Summit\", taught at Cornell from 1985 to 1989.[247] Plant genetics pioneer Ray Wu invented the first method for sequencing DNA, considered a major breakthrough in genetics as it has enabled researchers to more closely understand how genes work.[248][249] Emmy Award-winning actor John Cleese, known for his roles in Monty Python, James Bond, Harry Potter and Shrek, has taught at Cornell since 1999.[250] Charles Evans Hughes taught in the law school from 1893 to 1895 before becoming Governor of New York, United States Secretary of State, and Chief Justice of the United States.[251] Georgios Papanikolaou, who taught at Cornell's medical school from 1913 to 1961, invented the Pap smear test for cervical cancer.[252] Robert C. Baker ('43), widely credited for inventing the chicken nugget, taught at Cornell from 1957 to 1989. Carl Sagan was a professor at the university from 1968 to 1996.[253] He narrated and co-wrote the PBS series Cosmos, the Emmy Award- and Peabody Award-winning show that became the most watched series in public-television history. He also wrote the novel Contact, the basis for a 1997 film of the same name, and he won a Pulitzer Prize for his novel The Dragons of Eden: Speculations on the Evolution of Human Intelligence. M. H. Abrams was a professor emeritus of English and was the founding editor of The Norton Anthology of English Literature.[254] James L. Hoard, a scientist who worked on the Manhattan Project\n" +
                "\n" +
                "Vladimir Nabokov taught Russian and European literature at Cornell between 1948 and 1959.[255]\n" +
                "\n" +
                "Cornell has twice (2008 and 2009) been named a \"Great College to Work For\" by The Chronicle of Higher Education, due to receiving high ratings in compensation and benefits, connection to institution and pride, faculty-administration relations, job satisfaction, and post-retirement benefits.[256] Many faculty, and president, live in the upscale suburb of Cayuga Heights, directly north of campus.\n" +
                "\n" +
                "Famous current and former Cornell faculty\n" +
                "\n" +
                "Norman Borlaug\n" +
                "(CALS, 1982-88)\n" +
                "\"Father of the Green Revolution\"\n" +
                "\n" +
                "John Cleese\n" +
                "(A&S, 1999-)\n" +
                "Emmy Award-winning actor\n" +
                "\n" +
                "Henry Louis Gates, Jr.\n" +
                "(A&S, 1985-89)\n" +
                "Emmy Award-winning filmmaker and scholar\n" +
                "\n" +
                "Charles Evans Hughes\n" +
                "(Law, 1893-95)\n" +
                "Secretary of State / Chief Justice of the United States\n" +
                "\n" +
                "Frances Perkins\n" +
                "(ILR, 1952-65)\n" +
                "First female member of the Cabinet of the United States\n" +
                "\n" +
                "Carl Sagan\n" +
                "(CAS, 1968–96)\n" +
                "Co-writer and narrator of Cosmos: A Personal Voyage\n" +
                "Alumni\n" +
                "Main article: List of Cornell University alumni\n" +
                "Cornell counted 245,027 living alumni as of August 2008.[9] Its alumni constitute 31 Marshall Scholars and 28  Rhodes Scholars,[9][11] and Cornell is the only university with three female winners (Pearl S. Buck, Barbara McClintock, and Toni Morrison) of unshared Nobel Prizes among its graduates.[10][257] Many alumni maintain university ties through Homecoming's reunion weekend, through Cornell Magazine,[258] and through the Cornell Club of New York. In 2015, Cornell ranked #5 nationwide for gifts and bequests from alumni.[98]\n" +
                "\n" +
                "\n" +
                "The Cornell Club in New York City is a focal point for alumni.\n" +
                "Cornell alumni are noted for their accomplishments in public, professional, and corporate life.[9][259] Lee Teng-hui was the president of Taiwan,[260] Tsai Ing-wen was elected to be the first female president of Taiwan,[261] Mario García Menocal was president of Cuba,[262] Jamshid Amuzegar ('50) was prime minister of Iran,[263] Hu Shih (1914) was a Chinese reformer and representative to the United Nations,[264] Janet Reno ('60) was the first female United States Attorney General,[265] and Ruth Bader Ginsburg ('54) serves on the Supreme Court.[266] Alumnus David Starr Jordan (1872) was the founding president of Stanford University,[267] and M. Carey Thomas (1877) founded Bryn Mawr College.[268] Additionally, alumnus Matt Urban ('41) holds the distinction as the most decorated serviceman in United States history.[269]\n" +
                "\n" +
                "Cornellians in business include: Citigroup CEO Sanford Weill ('55),[270] Goldman Sachs Group Chairman Stephen Friedman ('59),[271] Kraft Foods CEO Irene Rosenfeld ('75, '77, '80),[272] Autodesk CEO Carl Bass ('83),[273] Aetna CEO Mark Bertolini ('84),[274] S.C. Johnson & Son CEO Fisk Johnson ('79, '80, '82, '84, '86),[275] Cargill Chairman Warren Staley ('67),[276] Chevron Chairman Kenneth T. Derr ('59),[277] Sprint Nextel CEO Dan Hesse ('77),[278] Verizon CEO Lowell McAdam ('76),[279] MasterCard CEO Robert Selander ('72),[280] Coors Brewing Company CEO Adolph Coors ('37),[281] Loews Corporation Chairman Andrew Tisch ('71),[282] Burger King founder James McLamore ('47),[283] Hotels.com founder David Litman ('79),[284] PeopleSoft founder David Duffield ('62),[285] Priceline.com founder Jay Walker ('77),[286] Staples founder Myra Hart ('62),[287] Qualcomm founder Irwin M. Jacobs ('56),[288] Tata Group CEO Ratan Tata ('62),[289]Nintendo of America President and COO Reggie Fils-Aimé,[290] and Johnson & Johnson worldwide chairman Sandi Peterson.[291]\n" +
                "\n" +
                "In medicine, alumnus Robert Atkins ('55) developed the Atkins Diet,[292] Henry Heimlich ('47) developed the Heimlich maneuver,[293] Wilson Greatbatch ('50) invented the pacemaker,[294] James Maas ('66; also a faculty member) coined the term \"power nap\",[295] and C. Everett Koop ('41) served as Surgeon General of the United States.[296]\n" +
                "\n" +
                "A number of Cornellians have been prominent innovators. Thomas Midgley, Jr. ('11) invented Freon,[297] Jon Rubinstein ('78) is credited with the development of the iPod,[298] and Robert Tappan Morris developed the first computer worm on the Internet. Eight Cornellians have served as NASA astronauts, Steve Squyres ('81) is the principal investigator on the Mars Exploration Rover Mission.[299] In aerospace, also, Otto Glasser ('40) directed the USAF program that developed the SM-65 Atlas, the World's first operational Intercontinental ballistic missile. Bill Nye ('77) is well known as \"The Science Guy\".[300] Róisín Owens, an Irish biochemist and world-leader in bioelectronics.[301]\n" +
                "\n" +
                "In literature, Toni Morrison ('50; Nobel laureate) is well known for her novel Beloved, Pearl S. Buck ('25; Nobel laureate) authored The Good Earth,[302] Thomas Pynchon ('59) penned such canonical works of postwar American fiction as Gravity's Rainbow and The Crying of Lot 49, Junot Díaz ('95) wrote The Brief Wondrous Life of Oscar Wao for which he won the Pulitzer Prize for fiction,[303] and E. B. White ('21) authored Charlotte's Web and Stuart Little.[304] Media personalities who have graduated from Cornell include conservative Ann Coulter ('84)[305] and liberals Bill Maher ('78) and Keith Olbermann ('79),[306] David Van Leer (Ph.D. '78) was an American educator and LGBT cultural studies researcher.\n" +
                "\n" +
                "Several Cornellians have also achieved critical acclaim in entertainment. Dan Duryea ('28) became a well-known Hollywood Actor in the 1940s-1960s,[307] Christopher Reeve ('74) played Superman,[270] Frank Morgan was The Wizard of Oz, Jimmy Smits ('82) was in Star Wars: Attack of the Clones,[270] Ronald D. Moore created the 2004 remake of Battlestar Galactica, and Kovid Gupta became a bestselling author and Bollywood media mogul. On the architectural front, alumnus Richmond Shreve (1902) designed the Empire State Building,[308] and Raymond M. Kennedy ('15) designed Hollywood's famous Grauman's Chinese Theatre.[309]\n" +
                "\n" +
                "In athletics, Cornell graduates include football legend Glenn \"Pop\" Warner (1894),[310] head coach of the United States men's national soccer team Bruce Arena ('73),[311] National Hockey League commissioner Gary Bettman ('74),[312] six-time Stanley Cup winning hockey goalie Ken Dryden ('69),[313] tennis singles world # 2 Dick Savitt,[314] seven-time US Tennis championships winner William Larned and Toronto Raptors president Bryan Colangelo ('87),[315] and Kyle Dake, four-time NCAA division I wrestling national champion.");

    }
}
