import { useEffect, useState } from "react";
import {
  Card,
  CardBody,
  Image,
  Heading,
  Text,
  Spinner,
  Button,
  SimpleGrid,
  Flex,
  Alert,
  AlertIcon,
  Badge,
  HStack,
  Icon,
  Checkbox,
  VStack,
  Box,
  Select,
} from "@chakra-ui/react";
import axios from "axios";
import { FaStar, FaExternalLinkAlt } from "react-icons/fa";
import Pagination from "./Pagination";

const API_KEY = "706ba3379c0f4e52a2edd66931a84657"; // Replace with your RAWG API key
const API_URL = `https://api.rawg.io/api/games?key=${API_KEY}`;

interface Game {
  id: number;
  name: string;
  background_image: string | null;
  released: string;
  rating: number;
  metacritic?: number;
  platforms: { platform: { id: number; name: string } }[];
  genres: { name: string }[];
}

const genresList = ["Action", "Adventure", "RPG", "Shooter", "Puzzle"];
const platformsList = [
  "PC",
  "PlayStation 4",
  "PlayStation 5",
  "Xbox 360",
  "Xbox One",
  "Nintendo Switch",
  "Android",
  "iOS",
];

const yearsList = Array.from({ length: 20 }, (_, i) => (2024 - i).toString()); // Generates years from 2024 to 2005

function GameCard() {
  const [games, setGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState(true);
  const [page, setPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  const [error, setError] = useState<string | null>(null);
  const [selectedGenres, setSelectedGenres] = useState<string[]>([]);
  const [selectedPlatforms, setSelectedPlatforms] = useState<string[]>([]);
  const [selectedYear, setSelectedYear] = useState<string>("");

  useEffect(() => {
    setLoading(true);
    setError(null);

    let url = `${API_URL}&page=${page}`;
    if (selectedYear) url += `&dates=${selectedYear}-01-01,${selectedYear}-12-31`;

    axios
      .get(url)
      .then((response) => {
        setGames(response.data.results);

        const calculatedPages = Math.ceil(
          response.data.count / response.data.results.length
        );
        if (calculatedPages !== totalPages) {
          setTotalPages(calculatedPages);
        }

        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching games:", error);
        setError("Failed to load games. Please try again later.");
        setLoading(false);
      });
  }, [page, selectedYear]);

  // Filter games based on selected genres, platforms, and release year
  const filteredGames = games.filter((game) => {
    const matchesGenre =
      selectedGenres.length === 0 ||
      game.genres.some((genre) => selectedGenres.includes(genre.name));

    const matchesPlatform =
      selectedPlatforms.length === 0 ||
      game.platforms.some((p) =>
        selectedPlatforms.includes(p.platform.name)
      );

    return matchesGenre && matchesPlatform;
  });

  const handleGenreChange = (genre: string) => {
    setSelectedGenres((prev) =>
      prev.includes(genre)
        ? prev.filter((g) => g !== genre)
        : [...prev, genre]
    );
  };

  const handlePlatformChange = (platform: string) => {
    setSelectedPlatforms((prev) =>
      prev.includes(platform)
        ? prev.filter((p) => p !== platform)
        : [...prev, platform]
    );
  };

  if (loading) return <Spinner size="xl" />;

  return (
    <Flex>
      {/* Sidebar Filters */}
      <Box w="250px" p={4} borderRight="1px solid #e2e8f0">
        <Heading size="md" mb={3}>
          Filters
        </Heading>

        <Text fontWeight="bold" mt={2}>
          Genres
        </Text>
        <VStack align="start">
          {genresList.map((genre) => (
            <Checkbox
              key={genre}
              isChecked={selectedGenres.includes(genre)}
              onChange={() => handleGenreChange(genre)}
            >
              {genre}
            </Checkbox>
          ))}
        </VStack>

        <Text fontWeight="bold" mt={4}>
          Platforms
        </Text>
        <VStack align="start">
          {platformsList.map((platform) => (
            <Checkbox
              key={platform}
              isChecked={selectedPlatforms.includes(platform)}
              onChange={() => handlePlatformChange(platform)}
            >
              {platform}
            </Checkbox>
          ))}
        </VStack>

        <Text fontWeight="bold" mt={4}>
          Year of Release
        </Text>
        <Select
          placeholder="Select Year"
          onChange={(e) => setSelectedYear(e.target.value)}
          value={selectedYear}
        >
          {yearsList.map((year) => (
            <option key={year} value={year}>
              {year}
            </option>
          ))}
        </Select>
      </Box>

      {/* Main Content */}
      <Box flex="1" p={4}>
        {error && (
          <Alert status="error" mb={4}>
            <AlertIcon />
            {error}
          </Alert>
        )}

        <SimpleGrid columns={{ base: 1, md: 2, lg: 3 }} spacing={6}>
          {filteredGames.length > 0 ? (
            filteredGames.map((game) => (
              <Card
                key={game.id}
                maxW="sm"
                borderRadius="lg"
                overflow="hidden"
                boxShadow="lg"
              >
                <CardBody>
                  <Image
                    src={game.background_image || "https://via.placeholder.com/300"}
                    alt={game.name}
                    borderRadius="md"
                    objectFit="cover"
                    w="100%"
                    h="180px"
                  />
                  <Heading size="md" mt={2}>{game.name}</Heading>

                  <Text fontSize="sm" color="gray.500">
                    Released: {game.released}
                  </Text>

                  <HStack spacing={2} mt={2}>
                    <Icon as={FaStar} color="yellow.400" />
                    <Text fontSize="sm" fontWeight="bold">
                      {game.rating.toFixed(1)}
                    </Text>
                    {game.metacritic && (
                      <Badge
                        colorScheme={
                          game.metacritic >= 80
                            ? "green"
                            : game.metacritic >= 50
                            ? "yellow"
                            : "red"
                        }
                      >
                        Metacritic: {game.metacritic}
                      </Badge>
                    )}
                  </HStack>

                  <Text fontSize="sm" mt={2} fontWeight="semibold">
                    Genres: {game.genres.map((genre) => genre.name).join(", ") || "N/A"}
                  </Text>

                  <HStack spacing={2} mt={1} wrap="wrap">
                    {game.platforms.map((p) => (
                      <Badge key={p.platform.id} colorScheme="blue">
                        {p.platform.name}
                      </Badge>
                    ))}
                  </HStack>

                  <Button
                    mt={3}
                    w="full"
                    colorScheme="blue"
                    rightIcon={<FaExternalLinkAlt />}
                    onClick={() => window.open(`https://rawg.io/games/${game.id}`, "_blank")}
                  >
                    View Details
                  </Button>
                </CardBody>
              </Card>
            ))
          ) : (
            <Text>No games match the selected filters.</Text>
          )}
        </SimpleGrid>

        <Flex justify="center" mt={4}>
          <Pagination totalPages={totalPages} currentPage={page} onPageChange={setPage} />
        </Flex>
      </Box>
    </Flex>
  );
}

export default GameCard;
