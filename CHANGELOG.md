# Changelog

All notable changes to the Alogram PayRisk Java SDK will be documented in this file.

## [0.1.6-rc.3] - 2026-02-10

### Added
- Switched to `okhttp-jackson` library for professional interceptor and JSON support.
- Standardized "Smart" client architecture with hand-written façade.
- Resilient retry logic (429 & 5xx) with exponential backoff.
- Automated identity injection and tracing headers.

### Changed
- Synchronized with Payments Risk API v0.1.6-rc.3.

## [0.1.6-rc.1] - 2026-02-10

### Added
- Initial support for OpenTelemetry spans in Java client.
- Typed exception hierarchy for specific API error codes.

### Changed
- Synchronized with Payments Risk API v0.1.6.