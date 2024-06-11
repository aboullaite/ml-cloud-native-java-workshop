# The Software Supply Chain 

In this step, we are going to work on generating, and analyzing our application / container image [sbom and how it helps in securing our software suuply chain](https://en.wikipedia.org/wiki/Software_supply_chain).

Follow the instructions below to install  Docker scout
```
curl -fsSL https://raw.githubusercontent.com/docker/scout-cli/main/install.sh -o install-scout.sh
sh install-scout.sh

```
Docker added support recently to generte sbom files. Execute the following command to do so
```
docker scout sbom us-east1-docker.pkg.dev/$PROJECT_ID/ml-java-workshopp/ml-java-workshopp-app
```
While the default output is in human-readable form for quick review, the command supports a growing set of output formats that can be used more directly for integration into other systems and tools that can analyze SBOMs:
```
Usage:  docker scout sbom [OPTIONS] COMMAND

Examples:

  docker sbom alpine:latest                                          a summary of discovered packages
  docker sbom alpine:latest --format syft-json                       show all possible cataloging details
  docker sbom alpine:latest --output sbom.txt                        write report output to a file
  docker sbom alpine:latest --exclude /lib  --exclude '**/*.db'      ignore one or more paths/globs in the image


Options:
  -D, --debug                 show debug logging
      --exclude stringArray   exclude paths from being scanned using a glob expression
      --format string         report output format, options=[syft-json cyclonedx-xml cyclonedx-json github-0-json
                              spdx-tag-value spdx-json table text] (default "table")
      --layers string         [experimental] selection of layers to catalog, options=[squashed all] (default "squashed")
  -o, --output string         file to write the default report output to (default is STDOUT)
      --platform string       an optional platform specifier for container image sources (e.g. 'linux/arm64',
                              'linux/arm64/v8', 'arm64', 'linux')
      --quiet                 suppress all non-report output
  -v, --version               version for sbom

```
To demonstrate this flow, let’s look at a simple use case where ‘docker sbom’ is used to produce its data as SPDX JSON, which is then consumed by another tool. We’ll use Grype, Anchore’s open source vulnerability scanner, to produce a vulnerability report without needing to contact any remote scanning services:

Install grype
```
curl -sSfL https://raw.githubusercontent.com/anchore/grype/main/install.sh | sh -s -- -b .
```

Run Scout and pass the result to grype
```
docker scout sbom --format spdx us-east1-docker.pkg.dev/$PROJECT_ID/ml-java-workshopp/ml-java-workshopp-app | ./grype
```

What actions should we take based on the output ?
