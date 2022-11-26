-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 26 nov. 2022 à 20:49
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `messagerie`
--

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`) VALUES
(1, 'LACHGAR', 'Mohamed'),
(3, 'ALAOUI', 'Manale'),
(4, 'ARRAJ', 'Mohamed');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `empEmetteur` int(11) NOT NULL,
  `empRecepteur` int(11) NOT NULL,
  `objet` varchar(50) NOT NULL,
  `sujet` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`id`, `empEmetteur`, `empRecepteur`, `objet`, `sujet`, `date`) VALUES
(1, 1, 4, 'Réunion', 'Réunion de fin d\'année', '2022-11-26'),
(2, 1, 3, 'Réunion', 'Réunion de fin d\'année', '2022-11-25'),
(3, 4, 1, 'Stage', 'Stage à Marrakech', '2022-11-26'),
(4, 4, 3, 'Stage', 'Stage à Marrakech', '2022-11-26');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`,`empEmetteur`,`empRecepteur`),
  ADD KEY `fk_emetteur` (`empEmetteur`),
  ADD KEY `fk_recepteur` (`empRecepteur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `fk_emetteur` FOREIGN KEY (`empEmetteur`) REFERENCES `employe` (`id`),
  ADD CONSTRAINT `fk_recepteur` FOREIGN KEY (`empRecepteur`) REFERENCES `employe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
