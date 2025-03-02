import { VStack, HStack, Link, Text, Divider, Input, Button, Icon, Box } from "@chakra-ui/react";
import { FaFacebook, FaTwitter, FaInstagram, FaEnvelope } from "react-icons/fa";

const Footer = () => {
  return (
    <Box bgGradient="linear(to-r, gray.900, gray.800)" color="white" py={6} px={4} mt={8}>
      <VStack spacing={4} textAlign="center">
        <HStack spacing={6} justify="center">
          <Link href="#" _hover={{ textDecoration: "underline", color: "blue.300" }}>Privacy Policy</Link>
          <Link href="#" _hover={{ textDecoration: "underline", color: "blue.300" }}>Terms of Service</Link>
          <Link href="#" _hover={{ textDecoration: "underline", color: "blue.300" }}>Contact Us</Link>
        </HStack>

        <Divider borderColor="gray.600" />

        {/* Social Media Links */}
        <HStack spacing={4}>
          <Link href="#" isExternal>
            <Icon as={FaFacebook} boxSize={5} _hover={{ color: "blue.400" }} />
          </Link>
          <Link href="#" isExternal>
            <Icon as={FaTwitter} boxSize={5} _hover={{ color: "blue.400" }} />
          </Link>
          <Link href="#" isExternal>
            <Icon as={FaInstagram} boxSize={5} _hover={{ color: "pink.400" }} />
          </Link>
        </HStack>

        {/* Newsletter Subscription */}
        <VStack spacing={2}>
          <Text fontSize="sm">Subscribe to our Neeravi for updates</Text>
          <HStack>
            <Input placeholder="Enter your email" size="sm" bg="gray.700" border="none" />
            <Button size="sm" colorScheme="blue" leftIcon={<FaEnvelope />}>
              Subscribe
            </Button>
          </HStack>
        </VStack>

        <Text fontSize="xs" mt={2}>© {new Date().getFullYear()} Neeravi Game Store. All Rights Reserved.</Text>
      </VStack>
    </Box>
  );
};

export default Footer;
